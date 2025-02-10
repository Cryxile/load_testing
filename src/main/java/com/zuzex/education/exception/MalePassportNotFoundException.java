package com.zuzex.education.exception;

public class MalePassportNotFoundException extends RuntimeException {
    public MalePassportNotFoundException(Character lastNameInitial) {
        super("Male with such last name initial '" + lastNameInitial.toString() + "' not found");
    }
}
