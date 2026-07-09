package com.johurulislam.educationmanagementsystemwms.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " not found with id: " + id);
    }

    public ResourceNotFoundException(String resource, String key) {
        super(resource + " not found with key: " + key);
    }
}
