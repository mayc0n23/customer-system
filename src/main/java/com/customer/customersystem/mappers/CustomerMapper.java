package com.customer.customersystem.mappers;

import com.customer.customersystem.domain.Customer;
import com.customer.customersystem.dtos.request.CreateCustomerRequest;
import com.customer.customersystem.dtos.request.UpdateCustomerRequest;
import com.customer.customersystem.dtos.response.CustomerResponse;
import com.customer.customersystem.dtos.response.MinimalCustomerResponse;
import com.customer.customersystem.entities.CustomerEntity;

import java.util.List;

public class CustomerMapper {

    public static CustomerEntity mapDomainToEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .type(customer.getType())
                .fullName(customer.getFullName())
                .mainDocument(customer.getMainDocument())
                .secondaryDocument(customer.getSecondaryDocument())
                .registrationDate(customer.getRegistrationDate())
                .active(customer.isActive())
                .phones(PhoneMapper.mapDomainToEntity(customer.getPhones()))
                .build();
    }

    public static Customer mapEntityToDomain(CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getId(),
                customerEntity.getType(),
                customerEntity.getFullName(),
                customerEntity.getMainDocument(),
                customerEntity.getSecondaryDocument(),
                customerEntity.getRegistrationDate(),
                customerEntity.isActive(),
                PhoneMapper.mapEntityToDomain(customerEntity.getPhones())
        );
    }

    public static Customer mapCreateRequestToDomain(CreateCustomerRequest createCustomerRequest) {
        return new Customer(
                createCustomerRequest.getType(),
                createCustomerRequest.getFullName(),
                createCustomerRequest.getMainDocument(),
                createCustomerRequest.getSecondaryDocument(),
                createCustomerRequest.isActive(),
                PhoneMapper.mapCreateRequestToDomain(createCustomerRequest.getPhones())
        );
    }

    public static Customer mapUpdateRequestToDomain(UpdateCustomerRequest updateCustomerRequest) {
        return new Customer(
                updateCustomerRequest.getId(),
                updateCustomerRequest.getType(),
                updateCustomerRequest.getFullName(),
                updateCustomerRequest.getMainDocument(),
                updateCustomerRequest.getSecondaryDocument(),
                updateCustomerRequest.isActive(),
                PhoneMapper.mapUpdateRequestToDomain(updateCustomerRequest.getPhones())
        );
    }

    public static CustomerResponse mapDomainToResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .type(customer.getType())
                .fullName(customer.getFullName())
                .mainDocument(customer.getMainDocument())
                .secondaryDocument(customer.getSecondaryDocument())
                .registrationDate(customer.getRegistrationDate())
                .isActive(customer.isActive())
                .phones(PhoneMapper.mapDomainToResponse(customer.getPhones()))
                .build();
    }

    public static MinimalCustomerResponse mapDomainToMinimalResponse(Customer customer) {
        return MinimalCustomerResponse.builder()
                .id(customer.getId())
                .type(customer.getType())
                .fullName(customer.getFullName())
                .mainDocument(customer.getMainDocument())
                .active(customer.isActive())
                .build();
    }

    public static List<MinimalCustomerResponse> mapDomainToMinimalResponse(List<Customer> customers) {
        return customers.stream()
                .map(CustomerMapper::mapDomainToMinimalResponse)
                .toList();
    }

    public static void copyToDomainObject(Customer registered, Customer updated) {
        registered.setId(updated.getId());
        registered.setType(updated.getType());
        registered.setFullName(updated.getFullName());
        registered.setMainDocument(updated.getMainDocument());
        registered.setSecondaryDocument(updated.getSecondaryDocument());
        registered.setActive(updated.isActive());
        registered.setPhones(updated.getPhones());
    }

}