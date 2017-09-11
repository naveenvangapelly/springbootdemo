package com.example.exception.domain;

public class InvalidAcceptLanguageException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidAcceptLanguageException(String key) {
        super(key);
        return;
    }

    public InvalidAcceptLanguageException() {
        return;

    }
}
