package com.zuzex.education.exception;

import java.util.UUID;

public class OwnerCarNotFoundException extends RuntimeException {
    public OwnerCarNotFoundException(UUID ownerID) {
        super("Person " + ownerID.toString() + " doesn't own any car");
    }
}
