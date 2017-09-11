package com.example.exception.domain;

public class EmptyParamException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyParamException(String key) {
        super(key);
        return;
    }

    public EmptyParamException() {
        return;

    }
}
