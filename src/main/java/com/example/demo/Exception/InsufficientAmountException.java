package com.example.demo.Exception;

public class InsufficientAmountException extends RuntimeException{

    public InsufficientAmountException(String message) {
        super(message);
    }
}
