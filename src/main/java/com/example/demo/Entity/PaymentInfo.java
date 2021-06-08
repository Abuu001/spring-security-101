package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "payment_info")
@NoArgsConstructor
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;
    private  String accountNo;
    private double amount;
    private String cardType;
    private Long passengerId;

}
