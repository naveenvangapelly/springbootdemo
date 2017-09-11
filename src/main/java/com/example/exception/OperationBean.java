package com.example.exception;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OperationBean {

    private String          result;
    private List<ErrorBean> errors;
    private String          requestTimeStampUtc;
    private String          responseTimeStampUtc;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ErrorBean> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorBean> errors) {
        this.errors = errors;
    }

    public String getRequestTimeStampUtc() {
        return requestTimeStampUtc;
    }

    public void setRequestTimeStampUtc(String requestTimeStampUtc) {
        this.requestTimeStampUtc = requestTimeStampUtc;
    }

    public String getResponseTimeStampUtc() {
        return responseTimeStampUtc;
    }

    public void setResponseTimeStampUtc(String responseTimeStampUtc) {
        this.responseTimeStampUtc = responseTimeStampUtc;
    }

}
