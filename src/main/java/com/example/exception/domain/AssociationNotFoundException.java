package com.example.exception.domain;

public class AssociationNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AssociationNotFoundException(String key) {
        super(key);
        return;
    }

    public AssociationNotFoundException() {
        return;

    }

}
