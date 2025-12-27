package com.airtribe.learntrack.utils;

public class studentIdGenerator  implements IdGenerator{
    private static int counter = 0;
    public String generateId(){
        return "STUDENT-"+ ++counter;
    }

}
