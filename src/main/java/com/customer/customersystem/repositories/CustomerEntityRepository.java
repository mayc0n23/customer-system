package com.customer.customersystem.repositories;

import com.customer.customersystem.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerEntityRepository extends CustomJpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByMainDocument(String mainDocument);

}