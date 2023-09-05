package com.customer.customersystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.customer.customersystem.domain.Customer;
import com.customer.customersystem.domain.Phone;
import com.customer.customersystem.domain.Type;
import com.customer.customersystem.entities.CustomerEntity;
import com.customer.customersystem.exceptions.EntityNotFoundException;
import com.customer.customersystem.mappers.CustomerMapper;
import com.customer.customersystem.repositories.CustomerEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerEntityRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void shouldReturnCustomer() {
        Phone phone = new Phone("11", "963275412");
        Customer customer = new Customer(1L, Type.PHYSICAL, "TEST", "321.654.987-10", null,
                true, Collections.singletonList(phone));

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(CustomerMapper.mapDomainToEntity(customer)));

        final var result = service.searchById(1L);

        assertNotNull(result);
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenSearchByIdAndCustomerNotExist() {
        when(repository.findById(anyLong()))
                .thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class,
                () -> service.searchById(1L));
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenDeleteCustomerAndCustomerNotExist() {
        when(repository.existsById(anyLong())).thenReturn(false);

        assertThrows(EntityNotFoundException.class,
                () -> service.delete(1L));
    }

    @Test
    void shouldDeleteCustomer() {
        when(repository.existsById(anyLong())).thenReturn(true);

        service.delete(1L);

        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void shouldReturnAllCustomers() {
        Phone phone = new Phone("11", "963275412");
        Customer customer = new Customer(1L, Type.PHYSICAL, "TEST", "321.654.987-10", null,
                true, Collections.singletonList(phone));

        when(repository.findAll()).thenReturn(Collections.singletonList(CustomerMapper.mapDomainToEntity(customer)));

        final var result = service.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void shouldSaveNewCustomer() {
        Phone phone = new Phone("11", "963275412");
        Customer customer = new Customer(1L, Type.PHYSICAL, "TEST", "321.654.987-10", null,
                true, Collections.singletonList(phone));

        when(repository.findByMainDocument(anyString()))
                .thenReturn(Optional.empty());
        when(repository.save(any(CustomerEntity.class)))
                .thenAnswer(
                        (Answer<CustomerEntity>)
                                invocationOnMock -> {
                                    final var customerEntity = (CustomerEntity) invocationOnMock.getArguments()[0];
                                    return customerEntity;
                                });

        final var result = service.save(customer);

        assertNotNull(result);
    }

}