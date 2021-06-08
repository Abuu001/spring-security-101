package com.example.demo.Service;

import com.example.demo.Entity.PassengerInfo;
import com.example.demo.Entity.PaymentInfo;
import com.example.demo.Repository.PassengerInfoRepository;
import com.example.demo.Repository.PaymentInfoRepository;
import com.example.demo.Utils.PaymentUtils;
import com.example.demo.dto.FlightBookingAcknowledgement;
import com.example.demo.dto.FlightBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional //when there is an error at one point  << Rollback (dont save in Db)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        FlightBookingAcknowledgement acknowledgement =null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo=passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        //validating the amount of money
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo() , passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }

    public List<PassengerInfo> allpassengers() {
        return passengerInfoRepository.findAll();
    }

    public List<PaymentInfo> allpayments() {
        return paymentInfoRepository.findAll();
    }
}
