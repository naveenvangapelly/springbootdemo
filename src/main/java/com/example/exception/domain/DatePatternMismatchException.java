package com.example.exception.domain;

public class DatePatternMismatchException extends RuntimeException {

	private static final long serialVersionUID = -6339558784237134980L;

	public DatePatternMismatchException(String message) {
        super(message);
        return;
    }

    public DatePatternMismatchException() {
        return;

    }
}
