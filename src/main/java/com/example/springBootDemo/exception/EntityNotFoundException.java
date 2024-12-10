package com.example.springBootDemo.exception;

public class EntityNotFoundException extends DatabaseException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
