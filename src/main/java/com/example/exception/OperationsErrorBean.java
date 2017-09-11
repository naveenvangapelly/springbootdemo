package com.example.exception;

import org.springframework.stereotype.Component;

@Component
public class OperationsErrorBean {

    private OperationBean operation;

    public OperationBean getOperation() {
        return operation;
    }

    public void setOperation(OperationBean operation) {
        this.operation = operation;
    }

}