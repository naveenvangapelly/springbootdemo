package com.example.exception.domain;

public class UnidentifiedQueryParamException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnidentifiedQueryParamException(String key) {
        super(key);
        return;
    }

    public UnidentifiedQueryParamException() {
        return;

    }
}
