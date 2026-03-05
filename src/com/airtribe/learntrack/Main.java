package com.airtribe.learntrack;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.enums.currentMenu;
import com.airtribe.learntrack.exceptions.NoStudentFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.Repository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.enums.EnrollemntStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.utils.enrollmentIdGenerator;
import com.airtribe.learntrack.utils.IdGenerator;
import com.airtribe.learntrack.utils.courseIdGenerator;
import com.airtribe.learntrack.utils.studentIdGenerator;

import java.util.Scanner;

public class Main {

    static currentMenu currentStage = currentMenu.MainMenu;
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;
    static Repository<Student,String> studentRepository = new StudentRepository();
    static StudentService studentService = new StudentService(studentRepository);
    static IdGenerator studentIdGenerator = new studentIdGenerator();


    static Repository<Course,String> courseRepository = new CourseRepository();
    static CourseService courseService = new CourseService(courseRepository);
    static IdGenerator courseIDGenerator = new courseIdGenerator();

    static Repository<Enrollment,String> enrollmentRepository = new EnrollmentRepository();
    static EnrollmentService enrollmentService = new EnrollmentService((EnrollmentRepository) enrollmentRepository, (Repository<Student, String>) studentRepository, (Repository<Course, String>) courseRepository);
    static IdGenerator enrollmentIDGenerator = new enrollmentIdGenerator();


    public static void RenderMainMenu() {
        System.out.println("┌---    Welcome to Learn Track     ---┐");
        System.out.println("|--- Please select the menu option ---|");
        System.out.println("|--- 1. Manage Students            ---|");
        System.out.println("|--- 2. Manage Courses             ---|");
        System.out.println("|--- 3. Manage Enrollments         ---|");
        System.out.println("|--- 4. Exit                       ---|");
        System.out.println("└-------------------------------------┘");

        if (sc.hasNextInt()) {
            int mainMenuOption = sc.nextInt();

            switch (mainMenuOption) {
                case 1:
                    //handle Manage Students Menu
                    System.out.println("Manage Students Selected");
//                    RenderManageStudents();
                    currentStage=currentMenu.StudentsMenu;
                    break;
                case 2:
                    //handle Manage Courses Menu
                    System.out.println("Manage Courses Selected");
                    currentStage=currentMenu.CourseMenu;

                    break;
                case 3:
                    //handle Manage Enrollment Menu
                    System.out.println("Manage Enrollment Selected");
                    currentStage=currentMenu.EnrollmentMenu;

                    break;
                case 4:
                    running = false;
                    System.out.println("Exited");
                    break;
                default:
                    System.out.print("Please Enter a input in the valid range as displayed");


            }
        } else {
            System.out.println("Please Enter a valid Input");
        }
    }

    public static void RenderManageStudents(){
        System.out.println("┌---    Welcome to Learn Track      ---┐");
        System.out.println("|--- Please select the menu option  ---|");
        System.out.println("|--- 1. Add Student                ---|");
        System.out.println("|--- 2. View All  Students          ---|");
        System.out.println("|--- 3. Search By Student ID        ---|");
        System.out.println("|--- 4. Activate/Deactivate Student ---|");
        System.out.println("|--- 5. Back                        ---|");
        System.out.println("└--------------------------------------┘");
        if (sc.hasNextInt()) {
            int studentMenuOption = sc.nextInt();
            switch (studentMenuOption) {
                case 1:
                    //handle Manage Students Menu

                    System.out.println("Add Students Selected");
                    System.out.print("Enter Student's First Name : ");
                    String fName= sc.next();
                    System.out.print("Enter Last Name : ");
                    String lName= sc.next();
                    System.out.print("Enter email : ");
                    String email = sc.next();
                    System.out.print("Enter batch : ");
                    String batch = sc.next();
                    String Id = studentIdGenerator.generateId();
                    Student newStudent = new Student(fName,lName,email,email,true,Id);
                    studentService.addStudent(newStudent);
                    break;
                case 2:
                    //handle Manage Courses Menu
                    System.out.println("View Students Selected");
                    studentService.viewAllStudents();
                    break;
                case 3:
                    //handle Manage Enrollment Menu
                    System.out.println("Search Student Selected");
                    System.out.print("Enter Student ID : ");
                    String studentID= sc.next();
                    try{

                    Student requiredStudent =studentService.searchByID(studentID);
                    System.out.println(requiredStudent.toString());
                    }catch(NoStudentFoundException error) {
                        System.out.println("Searching failed" + error.getMessage());
                    }

                        break;
                case 4:
                    //handle Manage Enrollment Menu
                    System.out.println("Deactivate Student Selected");
                    System.out.print("Enter Student ID : ");
                    String studentId= sc.next();
                    studentService.deactivate(studentId);

                    break;
                case 5:
//                    running = false;
                    currentStage = currentMenu.MainMenu;
                    System.out.println("Main Menu");
                    break;
                default:
                    System.out.print("Please Enter a input in the valid range as displayed");


            }
        } else {
            System.out.println("Please Enter a valid Input");
        }


    }

    public static void RenderManageCourses(){
        System.out.println("┌---    Welcome to Learn Track     ---┐");
        System.out.println("|--- Please select the menu option ---|");
        System.out.println("|--- 1. Add New Courses            ---|");
        System.out.println("|--- 2. View All  Courses          ---|");
        System.out.println("|--- 3. Deactivate Course          ---|");
        System.out.println("|--- 4. Back                       ---|");
        System.out.println("└-------------------------------------┘");

        if (sc.hasNextInt()) {
            int studentMenuOption = sc.nextInt();

            switch (studentMenuOption) {
                case 1:
                    //handle Manage Students Menu
                    System.out.println("Add Course Selected");
//                    RenderManageStudents();
                    System.out.print("Enter Course Name : ");
                    sc.nextLine();
                    String courseName= sc.nextLine();
                    System.out.print("Enter Description : ");
                    String description= sc.nextLine();
                    System.out.print("Enter Duration In Weeks : ");
                    int durationInWeeks = sc.nextInt();

                    String Id = courseIDGenerator.generateId();
                    Course newCourse = new Course(courseName,description,durationInWeeks,true,Id);
                    courseService.addCourse(newCourse);
                    break;
                case 2:
                    //handle Manage Courses Menu
                    System.out.println("View All Course Selected");
                    courseService.viewAllCourse();
                    break;
                case 3:
                    //handle Manage Enrollment Menu
                    System.out.println("Deactivate Course Selected");
                    System.out.print("Enter Course ID : ");
                    String courseId= sc.next();
                    courseService.deactivate(courseId);
                    break;
                case 4:
//                    running = false;
                    currentStage = currentMenu.MainMenu;
                    System.out.println("Main Menu");
                    break;
                default:
                    System.out.print("Please Enter a input in the valid range as displayed");


            }
        } else {
            System.out.println("Please Enter a valid Input");
        }


    }

    public static void RenderManageEnrollments(){
        System.out.println("┌---    Welcome to Learn Track          ---┐");
        System.out.println("|--- Please select the menu option      ---|");
        System.out.println("|--- 1. Enroll Student in a course      ---|");
        System.out.println("|--- 2. View Enrollments for a student  ---|");
        System.out.println("|--- 3. Mark Enrollment                 ---|");
        System.out.println("|--- 4. Back                            ---|");
        System.out.println("└------------------------------------------┘");

        if (sc.hasNextInt()) {
            int studentMenuOption = sc.nextInt();

            switch (studentMenuOption) {
                case 1:
                    // Enroll student in a course
                    System.out.println("Enroll Selected");
                    System.out.print("Enter Student ID: ");
                    String stuId = sc.next();
                    System.out.print("Enter Course ID: ");
                    String courId = sc.next();
                    String enrollId = enrollmentIDGenerator.generateId();
                    enrollmentService.enrollStudent(enrollId, stuId, courId);
                    break;
                case 2:
                    //handle Manage Courses Menu
                    System.out.println("View Enroll Selected");
                    System.out.print("Enter Student ID to view enrollments: ");
                    String sId = sc.next();
                    enrollmentService.viewEnrollmentsForStudent(sId);
                    break;
                case 3:
                    //handle Manage Enrollment Menu
                    System.out.println("Mark Enrollment selected");
                    System.out.print("Enter Enrollment ID: ");
                    String eId = sc.next();
                    System.out.println("Select status: 1. ACTIVE  2. COMPLETED  3. CANCELLED");
                    int statusOption = sc.nextInt();
                    EnrollemntStatus status = EnrollemntStatus.ACTIVE;
                    if(statusOption==2) status = EnrollemntStatus.COMPLETED;
                    if(statusOption==3) status = EnrollemntStatus.CANCELLED;
                    enrollmentService.markEnrollment(eId, status);
                    break;
                case 4:
//                    running = false;
                    currentStage = currentMenu.MainMenu;
                    System.out.println("Main Menu");
                    break;
                default:
                    System.out.print("Please Enter a input in the valid range as displayed");


            }
        } else {
            System.out.println("Please Enter a valid Input");
        }


    }


    public static void main(String[] args) {


        while(running){
          switch(currentStage) {
              case currentMenu.MainMenu:
                  RenderMainMenu();
                  break;
              case currentMenu.StudentsMenu:
                  RenderManageStudents();
                  break;
              case currentMenu.CourseMenu:
                  RenderManageCourses();
                  break;
              case currentMenu.EnrollmentMenu:
                  RenderManageEnrollments();
                  break;
              default:
                  System.out.print("No menu selected");
          }

        }





    }
}

