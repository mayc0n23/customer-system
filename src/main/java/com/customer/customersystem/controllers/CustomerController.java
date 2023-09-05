package com.customer.customersystem.controllers;

import com.customer.customersystem.dtos.request.CreateCustomerRequest;
import com.customer.customersystem.dtos.request.UpdateCustomerRequest;
import com.customer.customersystem.dtos.response.CustomerResponse;
import com.customer.customersystem.dtos.response.MinimalCustomerResponse;
import com.customer.customersystem.mappers.CustomerMapper;
import com.customer.customersystem.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_PATH)
@RequiredArgsConstructor
public class CustomerController implements CustomerControllerOpenApi {

    private final CustomerService service;

    public static final String BASE_NAME = "api";

    public static final String BASE_PATH = "/" + BASE_NAME + "/v1/customers";

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse register(@Validated @RequestBody CreateCustomerRequest request) {
        var customer = CustomerMapper.mapCreateRequestToDomain(request);
        var customerRegistered = service.save(customer);
        return CustomerMapper.mapDomainToResponse(customerRegistered);
    }

    /*
    * TODO: Adicionar paginção nesse endpoint e o filtro pelo nome do cliente
    */
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MinimalCustomerResponse> listAll() {
        var customers = service.getAll();
        return CustomerMapper.mapDomainToMinimalResponse(customers);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse searchById(@PathVariable Long id) {
        var customer = service.searchById(id);
        return CustomerMapper.mapDomainToResponse(customer);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Override
    @PutMapping("/{id}")
    public CustomerResponse edit(@PathVariable Long id, @Validated @RequestBody UpdateCustomerRequest request) {
        var customer = CustomerMapper.mapUpdateRequestToDomain(request);
        var customerRegistered = service.searchById(id);
        CustomerMapper.copyToDomainObject(customerRegistered, customer);
        customerRegistered = service.save(customerRegistered);
        return CustomerMapper.mapDomainToResponse(customerRegistered);
    }

}
