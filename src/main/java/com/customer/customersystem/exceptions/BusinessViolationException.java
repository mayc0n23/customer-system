package com.customer.customersystem.exceptions;

public class BusinessViolationException extends RuntimeException {

    public BusinessViolationException(String message) {
        super(message);
    }

}