package com.zuzex.education.exception;

public class OwnerHouseNotFoundException extends RuntimeException {
    public OwnerHouseNotFoundException(String street) {
        super("House on " + street + " street doesn't have any owners");
    }
}
