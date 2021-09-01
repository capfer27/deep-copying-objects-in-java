package com.capfer.exceptions;

public class ObjectNotFoundException extends RuntimeException
{
    private final String message;

    public ObjectNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
