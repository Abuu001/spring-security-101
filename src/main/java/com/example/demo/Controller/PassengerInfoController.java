package com.example.demo.Controller;

import com.example.demo.Entity.PassengerInfo;
import com.example.demo.Entity.PaymentInfo;
import com.example.demo.Service.FlightBookingService;
import com.example.demo.dto.FlightBookingAcknowledgement;
import com.example.demo.dto.FlightBookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
@EnableTransactionManagement
public class PassengerInfoController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/bookflight")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return flightBookingService.bookFlightTicket(request);
    }

    @GetMapping("/allpassengers")
    public List<PassengerInfo> allpassengers(){
        return flightBookingService.allpassengers();
    }


    @GetMapping("/allpayments")
    public List<PaymentInfo> allpayments(){
        return flightBookingService.allpayments();
    }

}
