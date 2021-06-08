package com.example.demo.Utils;

import com.example.demo.Exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String,Double> paymentMap =new HashMap<>();

    static{
        paymentMap.put("account1" ,12000.0d);
        paymentMap.put("account2" ,200.55d);
        paymentMap.put("account3" ,890.45d);
        paymentMap.put("account4" ,5000.20d);
        paymentMap.put("account5" ,760.04d);
        paymentMap.put("account6" ,8000.0d);

    }

    public static boolean validateCreditLimit(String accNo,double paidAmount){
        if(paidAmount>paymentMap.get(accNo)){
            throw new InsufficientAmountException("insufficient funds !!! ⚠⚠⚠");
        }else {
            return true;
        }
    }
}
