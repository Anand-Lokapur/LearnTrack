package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.enums.EnrollemntStatus;
import com.airtribe.learntrack.exceptions.NoEnrollmentFoundException;
import com.airtribe.learntrack.exceptions.NoStudentFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepository implements  Repository<Enrollment,String> {


    private final List<Enrollment> enrollments= new ArrayList<>();
    public void save(Enrollment enrollment){
        enrollments.add(enrollment);
    }

    public Enrollment getById(String id){
        for(Enrollment enrollment: enrollments){

            if(enrollment.getId().equals(id)){
                return enrollment;
            }
        }
        throw new NoStudentFoundException("No Enrollment with "+ id + " found");
    }
    public List<Enrollment> getAll(){
        return enrollments;
    }


    public void deactivate(String id, EnrollemntStatus status){
        enrollments.stream().filter(s-> s.getId().equals(id)).findFirst().orElseThrow(()-> new NoEnrollmentFoundException("enrollment with "+id +" found")).setStatus(status);
    }

    public void deactivate(String id){
//        enrollments.stream().filter(s-> s.getId().equals(id)).findFirst().orElseThrow(()-> new NoEnrollmentFoundException("enrollment with "+id +" found")).setStatus(status);
    }

    public String toString(){
        return "Existing Students : {" + enrollments + "}";
    }
}
