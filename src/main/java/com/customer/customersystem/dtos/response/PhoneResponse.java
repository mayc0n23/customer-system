package com.customer.customersystem.dtos.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PhoneResponse {

    private Long id;

    private String code;

    private String number;

}
