package com.test.exception;

/**
 * @author forum
 * @since 24-10-2020.
 */
public class BackendException extends RuntimeException {
    public BackendException(String message) {
        super(message);
    }
}
