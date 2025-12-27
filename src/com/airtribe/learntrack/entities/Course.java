package com.airtribe.learntrack.entities;

public class Course {

    private String courseName;
    private String id;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course (String courseName,String description, int durationInWeeks, boolean active,String id){
            this.courseName = courseName;
            this.description = description;
            this.durationInWeeks = durationInWeeks;
            this.active= active;
            this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getDescription() {

        return description;
    }
    public int getDurationInWeeks(){
        return durationInWeeks;
    }

    public boolean getStatus(){
        return  active;
    }


    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void durationInWeeks(int durationInWeeks){
        this.durationInWeeks = durationInWeeks;
    }

    public void setActive(boolean status){
        this.active=status;
    }

    public String toString() {
        return "Course{id='" + id + "', name='" + courseName + "', + description '"+ description + " "+ " Duration In weeks '" + durationInWeeks+ " ', active= '" +  active + "'}";
    }


}
