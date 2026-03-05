package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exceptions.NoCourseFoundException;
import com.airtribe.learntrack.repository.Repository;
import com.airtribe.learntrack.repository.StudentRepository;

public class CourseService {

    private final Repository<Course,String> courseRepository ;
    public CourseService(Repository<Course,String> courseRepository){
        this.courseRepository = courseRepository;
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void viewAllCourse(){
        System.out.println(courseRepository.toString());

    }

    public Course searchByID(String ID){
        return courseRepository.getById(ID);
    }

    public void deactivate(String ID){
        try{

        courseRepository.deactivate(ID);
        System.out.println("deactivated Successfully");
        }catch(NoCourseFoundException err){
            System.out.println("deactivated failed" + err.getMessage());

        }
    }
}
