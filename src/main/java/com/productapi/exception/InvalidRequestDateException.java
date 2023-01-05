package com.productapi.exception;

public class InvalidRequestDateException extends RuntimeException {

    public InvalidRequestDateException() {}

    public InvalidRequestDateException(String message) {
        super(message);
    }
}
