package com.tads.ecommerce.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> errors = new ArrayList<>();
<<<<<<< HEAD
    public ValidationError(Instant timestamp, Integer status, String error, String path, List<FieldMessage> errors) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public List<FieldMessage> getErrors() {
        return errors;
=======

    public ValidationError(Instant timestamp, Integer status, String erro, String path) {
        super(timestamp, status, erro, path);
    }

    @Override
    public String getError() {
        return super.getError();
>>>>>>> 65bf0ec0ed77aeaaf02608d8860d0630916a21d0
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
