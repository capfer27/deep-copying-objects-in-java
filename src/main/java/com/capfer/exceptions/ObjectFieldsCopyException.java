package com.capfer.exceptions;

public class ObjectFieldsCopyException extends RuntimeException
{
    private final String message;

    public ObjectFieldsCopyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
