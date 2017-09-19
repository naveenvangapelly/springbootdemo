package com.example.exception.domain;

public class AccountIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8485546930012881047L;

	public AccountIdNotFoundException(String message) {
        super(message);
        return;
    }

    public AccountIdNotFoundException() {
        return;

    }

}
