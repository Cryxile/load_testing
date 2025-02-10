package com.zuzex.education.exception;

import java.util.UUID;

public class PassportNotFoundException extends RuntimeException {
    public PassportNotFoundException(UUID id) {
        super("Passport with such id (" + id.toString() + ") not exist in the table");
    }
}
