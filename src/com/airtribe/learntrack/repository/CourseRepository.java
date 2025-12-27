package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.exceptions.NoCourseFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository  implements Repository<Course,String> {

    private final List<Course> Courses= new ArrayList<>();

    public void save(Course Course){
        Courses.add(Course);
    }

    public Course getById(String id){
        for(Course Course: Courses){

            if(Course.getId().equals(id)){
                return Course;
            }
        }
        throw new NoCourseFoundException("No Course with "+ id + " found");
    }
    public List<Course> getAll(){
        return Courses;
    }



    public void deactivate(String id){
        Courses.stream().filter(s-> s.getId().equals(id)).findFirst().orElseThrow(()-> new NoCourseFoundException("Course with "+id +" found")).setActive(false);
    }

    public String toString(){
        return "Existing Courses : {" + Courses + "}";
    }
}
