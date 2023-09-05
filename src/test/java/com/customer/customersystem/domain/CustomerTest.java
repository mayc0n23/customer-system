package com.customer.customersystem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.customer.customersystem.exceptions.DomainValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

class CustomerTest {

    private static final int CPF_FORMATTED_QUANTITY_DIGITS = 14;

    private static final int CNPJ_FORMATTED_QUANTITY_DIGITS = 18;

    @ParameterizedTest
    @ValueSource(strings = {"321.654.987-10", "32165498710"})
    void shouldValidateMainDocumentAndReturnFormattedWhenTypeIsCpf(String value) {
        Phone phone = new Phone("11", "963275412");
        Customer customer = new Customer(Type.PHYSICAL, "TEST", value, null, true, Collections.singletonList(phone));

        String result = customer.validateMainDocument(value, customer.getType());

        assertEquals("321.654.987-10", result);
        assertEquals(CPF_FORMATTED_QUANTITY_DIGITS, result.length());
    }

    @ParameterizedTest
    @ValueSource(strings = {"33.546.998/0001-83", "33546998000183"})
    void shouldValidateMainDocumentAndReturnFormattedWhenTypeIsCnpj(String value) {
        Phone phone = new Phone("11", "963275412");
        Customer customer = new Customer(Type.LEGAL, "TEST", value, null, true, Collections.singletonList(phone));

        String result = customer.validateMainDocument(value, customer.getType());

        assertEquals("33.546.998/0001-83", result);
        assertEquals(CNPJ_FORMATTED_QUANTITY_DIGITS, result.length());
    }

    @Test
    void shouldThrowDomainValidationExceptionWhenCpfIsInvalid() {
        Phone phone = new Phone("11", "963275412");

        assertThrows(DomainValidationException.class,
                () -> new Customer(Type.PHYSICAL, "TEST", "321.654.987-100", null,
                        true, Collections.singletonList(phone)));
    }

    @Test
    void shouldThrowDomainValidationExceptionWhenCnpjIsInvalid() {
        Phone phone = new Phone("11", "963275412");

        assertThrows(DomainValidationException.class,
                () -> new Customer(Type.LEGAL, "TEST", "33.546.998/0001-8", null,
                        true, Collections.singletonList(phone)));
    }

}