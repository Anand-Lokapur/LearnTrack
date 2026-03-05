package com.airtribe.learntrack.exceptions;

public class NoCourseFoundException extends RuntimeException {
    public NoCourseFoundException(String message) {
        super(message);
    }
}
