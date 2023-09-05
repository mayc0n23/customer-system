package com.customer.customersystem.dtos.response;

import com.customer.customersystem.domain.Type;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class CustomerResponse {

    private Long id;

    private Type type;

    private String fullName;

    private String mainDocument;

    private String secondaryDocument;

    private LocalDateTime registrationDate;

    private boolean isActive;

    private List<PhoneResponse> phones;

}