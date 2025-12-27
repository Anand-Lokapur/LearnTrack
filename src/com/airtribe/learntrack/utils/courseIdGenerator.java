package com.airtribe.learntrack.utils;

public class courseIdGenerator implements IdGenerator {
    private static int counter = 0;

    public String generateId(){
        return "COURSE-"+ ++counter;
    }
}
