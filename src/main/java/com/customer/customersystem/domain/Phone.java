package com.customer.customersystem.domain;

import lombok.Getter;

@Getter
public class Phone {

    public Phone(Long id, String code, String number) {
        this.id = id;
        this.code = code;
        this.number = number;
    }

    public Phone(String code, String number) {
        this(null, code, number);
    }

    private Long id;

    private String code;

    private String number;

}
