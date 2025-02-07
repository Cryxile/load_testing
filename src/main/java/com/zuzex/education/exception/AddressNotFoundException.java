package com.zuzex.education.exception;

import java.util.UUID;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(UUID id) {
        super("Address with such ID (" + id.toString() + ") not exist in the table");
    }
}
