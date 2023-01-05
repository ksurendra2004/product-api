package com.productapi.exception;

public class NoSuchProductExistsException extends RuntimeException {

    public NoSuchProductExistsException() {}
    public NoSuchProductExistsException(String message) {
        super(message);
    }
}
