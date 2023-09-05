package com.customer.customersystem.services;

import com.customer.customersystem.domain.Customer;
import com.customer.customersystem.entities.CustomerEntity;
import com.customer.customersystem.exceptions.BusinessViolationException;
import com.customer.customersystem.exceptions.EntityNotFoundException;
import com.customer.customersystem.mappers.CustomerMapper;
import com.customer.customersystem.repositories.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static final String CUSTOMER_NOT_FOUND_MESSAGE = "O cliente de id %s não existe.";

    private final CustomerEntityRepository repository;

    @Transactional
    public Customer save(Customer customer) {
        var customerEntity = CustomerMapper.mapDomainToEntity(customer);
        repository.detach(customerEntity);

        Optional<CustomerEntity> existingCustomer = repository.findByMainDocument(customer.getMainDocument());
        if (existingCustomer.isPresent() && !existingCustomer.get().equals(customerEntity)) {
            throw new BusinessViolationException("Já existe um cliente cadastrado com o documento %s"
                    .formatted(customer.getMainDocument()));
        }

        customerEntity = repository.save(customerEntity);
        return CustomerMapper.mapEntityToDomain(customerEntity);
    }

    public List<Customer> getAll() {
        var customers = repository.findAll();
        return customers.stream()
                .map(CustomerMapper::mapEntityToDomain)
                .toList();
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(CUSTOMER_NOT_FOUND_MESSAGE.formatted(id));
        }
        repository.deleteById(id);
    }

    public Customer searchById(Long id) {
        return repository.findById(id)
                .map(CustomerMapper::mapEntityToDomain)
                .orElseThrow(() -> new EntityNotFoundException(CUSTOMER_NOT_FOUND_MESSAGE.formatted(id)));
    }

}
