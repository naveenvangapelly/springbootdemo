package com.example.exception.domain;

public class UnsupportedMediaTypeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnsupportedMediaTypeException(String key) {
        super(key);
        return;
    }

    public UnsupportedMediaTypeException() {
        return;

    }

}
