package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exceptions.NoStudentFoundException;
import com.airtribe.learntrack.repository.Repository;
import com.airtribe.learntrack.repository.StudentRepository;

public class StudentService {
        private final Repository<Student,String> studentRepository ;
    public StudentService(Repository<Student,String> studentRepository){
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void viewAllStudents(){
        System.out.println(studentRepository.toString());

    }

    public Student searchByID(String ID){

        return studentRepository.getById(ID);
    }

    public void deactivate(String ID){
        try {
            studentRepository.deactivate(ID);
            System.out.println("deactivated Successfully");
        }catch(NoStudentFoundException error){
            System.out.println("Enrollment failed: " + error.getMessage());
        }
    }

}
