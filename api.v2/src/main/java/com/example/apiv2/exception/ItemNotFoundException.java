package com.example.apiv2.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(int id) {

        super("Could not find Item " + id);

    }
}
