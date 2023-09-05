package com.customer.customersystem.mappers;

import com.customer.customersystem.domain.Phone;
import com.customer.customersystem.dtos.request.CreatePhoneRequest;
import com.customer.customersystem.dtos.request.UpdatePhoneRequest;
import com.customer.customersystem.dtos.response.PhoneResponse;
import com.customer.customersystem.entities.PhoneEntity;

import java.util.List;

public class PhoneMapper {

    public static PhoneEntity mapDomainToEntity(Phone phone) {
        return PhoneEntity.builder()
                .id(phone.getId())
                .code(phone.getCode())
                .number(phone.getNumber())
                .build();
    }

    public static List<PhoneEntity> mapDomainToEntity(List<Phone> phones) {
        return phones.stream()
                .map(PhoneMapper::mapDomainToEntity)
                .toList();
    }

    public static Phone mapEntityToDomain(PhoneEntity phoneEntity) {
        return new Phone(
                phoneEntity.getId(),
                phoneEntity.getCode(),
                phoneEntity.getNumber()
        );
    }

    public static List<Phone> mapEntityToDomain(List<PhoneEntity> phoneEntities) {
        return phoneEntities.stream()
                .map(PhoneMapper::mapEntityToDomain)
                .toList();
    }

    public static Phone mapCreateRequestToDomain(CreatePhoneRequest createPhoneRequest) {
        return new Phone(
                createPhoneRequest.getCode(),
                createPhoneRequest.getNumber()
        );
    }

    public static List<Phone> mapCreateRequestToDomain(List<CreatePhoneRequest> phones) {
        return phones.stream()
                .map(PhoneMapper::mapCreateRequestToDomain)
                .toList();
    }

    public static Phone mapUpdateRequestToDomain(UpdatePhoneRequest updatePhoneRequest) {
        return new Phone(
                updatePhoneRequest.getId(),
                updatePhoneRequest.getCode(),
                updatePhoneRequest.getNumber()
        );
    }

    public static List<Phone> mapUpdateRequestToDomain(List<UpdatePhoneRequest> phones) {
        return phones.stream()
                .map(PhoneMapper::mapUpdateRequestToDomain)
                .toList();
    }

    public static PhoneResponse mapDomainToResponse(Phone phone) {
        return PhoneResponse.builder()
                .id(phone.getId())
                .code(phone.getCode())
                .number(phone.getNumber())
                .build();
    }

    public static List<PhoneResponse> mapDomainToResponse(List<Phone> phones) {
        return phones.stream()
                .map(PhoneMapper::mapDomainToResponse)
                .toList();
    }

}
