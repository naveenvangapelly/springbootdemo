package com.example.exception.domain;

public class QueryParamsNotAllowedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QueryParamsNotAllowedException(String key) {
        super(key);
        return;
    }

    public QueryParamsNotAllowedException() {
        return;

    }

}
