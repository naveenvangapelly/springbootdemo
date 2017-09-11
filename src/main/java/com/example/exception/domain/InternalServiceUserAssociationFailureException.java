package com.example.exception.domain;

public class InternalServiceUserAssociationFailureException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InternalServiceUserAssociationFailureException(String key) {
        super(key);
        return;
    }

    public InternalServiceUserAssociationFailureException() {
        return;

    }
}