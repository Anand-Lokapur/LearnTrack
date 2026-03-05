package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exceptions.NoStudentFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements Repository<Student,String> {

        private final List<Student> students= new ArrayList<>();

        public void save(Student student){
            students.add(student);
        }

        public Student getById(String id){
            for(Student student: students){

                if(student.getId().equals(id)){
                    return student;
                }
            }
        throw new NoStudentFoundException("No Student with "+ id + " found");
        }
        public List<Student> getAll(){
            return students;
        }

        public Optional<Student> getByEmail(String email){
            return students.stream().filter(s->s.getEmail().equalsIgnoreCase(email)).findFirst();
        }

        public void deactivate(String id){
            students.stream().filter(s-> s.getId().equals(id)).findFirst().orElseThrow(()-> new NoStudentFoundException("student with "+id +" found")).setStatus(false);
        }

        public String toString(){
            return "Existing Students : {" + students + "}";
        }

}
