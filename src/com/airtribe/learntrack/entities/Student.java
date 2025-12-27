package com.airtribe.learntrack.entities;

public class Student extends Person {
    private String batch;
    private boolean active;
    private String id;
    public Student(String firstName,String lastName,String email,String batch,boolean active,String id){
            super(firstName,lastName,email);
            this.batch = batch;
            this.active=active;
            this.id=id;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public String getBatch() {
    return batch;
    }
    public boolean getStatus(){
        return active;
    }

    public void setStatus(boolean status){
        this.active = status;
    }

    public void setBatch(String batch){
        this.batch= batch;
    }
    public String getId(){
        return id;
    }

    public String toString() {
        return "Student{id='" + id + "', name='" + firstName + " " + lastName +
                "', email='" + email + "', active=" + active + "}";
    }



}
