package com.customer.customersystem.domain;

import com.customer.customersystem.utils.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DocumentType {

    CPF(Patterns.CPF_PATTERN, Patterns.CPF_VALIDATOR_PATTERN, Patterns.CPF_MASK_PATTERN),
    CNPJ(Patterns.CNPJ_PATTERN, Patterns.CNPJ_VALIDATOR_PATTERN, Patterns.CNPJ_MASK_PATTERN);

    private final String pattern;

    private final String patternValidator;

    private final String mask;

    DocumentType(String pattern, String patternValidator, String mask) {
        this.pattern = pattern;
        this.patternValidator = patternValidator;
        this.mask = mask;
    }

    public String applyMask(String document) {
        Pattern pattern = Pattern.compile(this.mask);
        Matcher matcher = pattern.matcher(document);
        if (matcher.matches()) {
            return matcher.replaceFirst(this.pattern);
        }
        return document;
    }

    public boolean isValidDocument(String document) {
        return document.matches(this.patternValidator);
    }

}
