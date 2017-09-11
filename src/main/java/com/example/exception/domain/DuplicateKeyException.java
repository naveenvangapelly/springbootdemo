package com.example.exception.domain;

public class DuplicateKeyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateKeyException(String key) {
        super(key);
        return;
    }

    public DuplicateKeyException() {
        return;

    }

}
