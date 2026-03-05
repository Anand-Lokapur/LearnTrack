package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.enums.EnrollemntStatus;
import com.airtribe.learntrack.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentService {

    private final Repository<Enrollment, String> enrollmentRepository;
    private final Repository<Student, String> studentRepository;
    private final Repository<Course, String> courseRepository;

    public EnrollmentService(Repository<Enrollment, String> enrollmentRepository,
                             Repository<Student, String> studentRepository,
                             Repository<Course, String> courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void enrollStudent(String enrollmentId, String studentId, String courseId) {
        // validate student and course exist (repositories throw when not found)
        try {
            Student s = studentRepository.getById(studentId);
            Course c = courseRepository.getById(courseId);

            String date = LocalDate.now().toString();
            Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, date, EnrollemntStatus.ACTIVE);
            enrollmentRepository.save(enrollment);
            System.out.println("Enrolled " + s.getFirstName() + " " + s.getLastName() + " in course: " + c.getCourseName() + " with Enrollment ID: " + enrollmentId);
        } catch (RuntimeException ex) {
            // repository implementations throw specific exceptions; surface a simple message here
            System.out.println("Enrollment failed: " + ex.getMessage());
        }
    }

    public void viewEnrollmentsForStudent(String studentId) {
        List<Enrollment> all = enrollmentRepository.getAll();
        List<Enrollment> matches = all.stream().filter(e -> e.getStudentId().equals(studentId)).collect(Collectors.toList());
        if (matches.isEmpty()) {
            System.out.println("No enrollments found for student id: " + studentId);
            return;
        }
        System.out.println(matches);
    }

    public void markEnrollment(String enrollmentId, EnrollemntStatus newStatus) {
        try {
            Enrollment e = enrollmentRepository.getById(enrollmentId);
            e.setStatus(newStatus);
            System.out.println("Updated enrollment " + enrollmentId + " to status " + newStatus);
        } catch (RuntimeException ex) {
            System.out.println("Failed to update enrollment: " + ex.getMessage());
        }
    }

}
