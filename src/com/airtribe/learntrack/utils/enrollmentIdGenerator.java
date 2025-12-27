package com.airtribe.learntrack.utils;

public class enrollmentIdGenerator implements IdGenerator{
    private static int counter = 0;

    public String generateId(){
        return "ENROLL-" + ++counter;
    }

}
