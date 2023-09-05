package com.customer.customersystem.dtos.request;

import com.customer.customersystem.domain.Type;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class UpdateCustomerRequest {

    @NotNull(message = "O id do cliente deve ser informado")
    private Long id;

    @NotNull(message = "O tipo do cliente deve ser informado")
    private Type type;

    @NotBlank(message = "O nome do cliente é obrigatório")
    private String fullName;

    @NotBlank(message = "O CPF/CNPJ do cliente é obrigatório")
    private String mainDocument;

    private String secondaryDocument;

    @NotNull
    private boolean active;

    @NotNull
    @Valid
    private List<UpdatePhoneRequest> phones;

}
