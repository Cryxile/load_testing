package com.zuzex.education.exception;

import java.util.UUID;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(UUID id) {
        super("Car with such ID (" + id.toString() + ") not exist in the table");
    }
}
