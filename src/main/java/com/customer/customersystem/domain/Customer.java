package com.customer.customersystem.domain;

import com.customer.customersystem.exceptions.DomainValidationException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Customer {

    public Customer(Long id, Type type, String fullName, String mainDocument, String secondaryDocument,
                    LocalDateTime registrationDate, boolean active, List<Phone> phones) {

        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.mainDocument = validateMainDocument(mainDocument, this.type);
        this.secondaryDocument = secondaryDocument;
        this.registrationDate = registrationDate;
        this.active = active;
        this.phones = phones;
    }

    public Customer(Type type, String fullName, String mainDocument, String secondaryDocument, boolean active, List<Phone> phones) {
        this(null, type, fullName, mainDocument, secondaryDocument, null, active, phones);
    }

    public Customer(Long id, Type type, String fullName, String mainDocument, String secondaryDocument, boolean active, List<Phone> phones) {
        this(id, type, fullName, mainDocument, secondaryDocument, null, active, phones);
    }

    private Long id;

    private Type type;

    private String fullName;

    private String mainDocument;

    private String secondaryDocument;

    private LocalDateTime registrationDate;

    private boolean active;

    private List<Phone> phones;

    String validateMainDocument(String mainDocument, Type type) {
        final var documentType = type.getDocumentType();
        if (!documentType.isValidDocument(mainDocument)) {
            throw new DomainValidationException("CPF/CNPJ inválido.");
        }
        return documentType.applyMask(mainDocument);
    }

}