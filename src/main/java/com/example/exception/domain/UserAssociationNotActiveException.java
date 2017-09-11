package com.example.exception.domain;

public class UserAssociationNotActiveException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserAssociationNotActiveException(final String key) {
        super(key);
        return;
    }

    public UserAssociationNotActiveException() {
        return;

    }

}
