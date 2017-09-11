package com.example.exception.domain;

public class AccountHolderAssociationNotActiveException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountHolderAssociationNotActiveException(final String key) {
        super(key);
        return;
    }

    public AccountHolderAssociationNotActiveException() {
        return;

    }

}
