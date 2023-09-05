package com.customer.customersystem.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CreatePhoneRequest {

    @NotBlank(message = "O campo DDD é obrigatório")
    private String code;

    @NotBlank(message = "O número do telefone/celular é obrigatório")
    private String number;

}
