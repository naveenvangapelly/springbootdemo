package com.example.exception.domain;

public class AccountFirstNameNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -6185786444426649582L;

	public AccountFirstNameNotFoundException(String message) {
        super(message);
        return;
    }

    public AccountFirstNameNotFoundException() {
        return;

    }
}
