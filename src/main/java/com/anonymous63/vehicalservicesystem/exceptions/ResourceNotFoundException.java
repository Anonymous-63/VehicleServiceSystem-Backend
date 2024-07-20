package com.anonymous63.vehicalservicesystem.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    final String entityName;
    final String fieldName;
    final Object fieldValue;

    public ResourceNotFoundException(String entityName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", entityName, fieldName, fieldValue));
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
