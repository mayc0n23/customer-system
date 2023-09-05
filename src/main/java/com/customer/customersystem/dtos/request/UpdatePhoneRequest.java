package com.customer.customersystem.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdatePhoneRequest {

    @NotNull(message = "O id do telefone deve ser informado")
    private Long id;

    @NotBlank(message = "O campo DDD é obrigatório")
    @Size(min = 2, max = 2)
    private String code;

    @NotBlank(message = "O número do telefone/celular é obrigatório")
    @Size(min = 8, max = 9)
    private String number;

}
