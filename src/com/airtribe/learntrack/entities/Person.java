package com.airtribe.learntrack.entities;

public class Person {
        protected String firstName;
        protected String lastName;
        protected String email;

    public Person(String firstName,String lastName,String email){
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
    }

    public String getFullName(){
        return firstName.concat(lastName);
    }

    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getEmail(){
        return email;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setEmail(String email){
        this.email = email;
    }





}
