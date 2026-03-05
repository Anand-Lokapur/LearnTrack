package com.airtribe.learntrack.entities;

import com.airtribe.learntrack.enums.EnrollemntStatus;

public class Enrollment {

    private String id;
    private String studentId;
    private String courseId;
    private String enrollmentDate;
    private EnrollemntStatus status;

    public Enrollment(String id, String studentId, String courseId, String enrollmentDate, EnrollemntStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }


    public String getId() {
        return id;
    }


    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }


    public String getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }


    public EnrollemntStatus getStatus() {
        return status;
    }
    public void setStatus(EnrollemntStatus status) {
        this.status = status;
    }

    public String toString() {
        return "enrollemnt{id='" + id + "', student Id='" + studentId + "', + courseId '"+ courseId + " "+ " enrollment Date '" + enrollmentDate+ " ', status= '" +  status + "'}";
    }



}
