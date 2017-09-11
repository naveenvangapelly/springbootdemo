package com.example.exception.domain;

public class UnmatchedQueryParamValueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnmatchedQueryParamValueException(String key) {
        super(key);
        return;
    }

    public UnmatchedQueryParamValueException() {
        return;

    }
}
