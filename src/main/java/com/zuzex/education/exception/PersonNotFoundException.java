package com.zuzex.education.exception;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id) {
        super("Person with such id (" + id.toString() + ") not exist in the table");
    }
}
