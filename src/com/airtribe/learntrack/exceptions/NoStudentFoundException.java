package com.airtribe.learntrack.exceptions;

public class NoStudentFoundException extends RuntimeException {
    public NoStudentFoundException(String message) {
        super(message);
    }
}
