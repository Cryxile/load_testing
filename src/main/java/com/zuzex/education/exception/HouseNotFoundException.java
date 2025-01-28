package com.zuzex.education.exception;

import java.util.UUID;

public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException(UUID id) {
        super("House with such ID (" + id.toString() + ") not exist in the table");
    }
}
