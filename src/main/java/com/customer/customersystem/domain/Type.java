package com.customer.customersystem.domain;

public enum Type {

    PHYSICAL(DocumentType.CPF),
    LEGAL(DocumentType.CNPJ);

    private final DocumentType documentType;

    Type(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

}
