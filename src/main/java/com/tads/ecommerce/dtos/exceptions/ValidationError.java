package com.tads.ecommerce.dtos.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path, List<FieldMessage> errors) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public ValidationError(Instant timestamp, Integer status, String erro, String path) {
        super(timestamp, status, erro, path);
    }

    @Override
    public String getError() {
        return super.getError();
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
