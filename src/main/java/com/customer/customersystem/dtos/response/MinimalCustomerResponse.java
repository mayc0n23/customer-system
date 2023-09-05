package com.customer.customersystem.dtos.response;

import com.customer.customersystem.domain.Type;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MinimalCustomerResponse {

    private Long id;

    private Type type;

    private String fullName;

    private String mainDocument;

}
