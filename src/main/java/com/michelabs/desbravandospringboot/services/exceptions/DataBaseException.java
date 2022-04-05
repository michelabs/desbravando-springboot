package com.michelabs.desbravandospringboot.services.exceptions;

public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataBaseException(String str) {
        super(str);
    }
}
