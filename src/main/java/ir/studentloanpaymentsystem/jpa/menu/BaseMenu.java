package ir.studentloanpaymentsystem.jpa.menu;

import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.University;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;
import ir.studentloanpaymentsystem.jpa.validation.SignupValidation;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import static ir.studentloanpaymentsystem.jpa.menu.LoanMenu.studentEntity;
import static ir.studentloanpaymentsystem.jpa.util.DateApplication.addDate;
import static ir.studentloanpaymentsystem.jpa.validation.SignupValidation.*;

public class BaseMenu {
     public static final Scanner scanner = new Scanner(System.in);
     public static Optional<Student> optionalStudent;

     public static void fistMenu() {
          Scanner scanner = new Scanner(System.in);
          System.out.println("\n*************************************************************");
          System.out.println("|        $     *- WELCOMT TO LOAN PAYMENT SYSTEM  -*     $    |");
          System.out.println("|      </>         Develope By Hosein Rezaei           </>    |");
          System.out.println("*************************************************************\n");
          System.out.println("1- Sign in");
          System.out.println("2- Sign up");
          System.out.println("3- Exit\n");
          System.out.println("Enter your select:");
          try {
               int select = scanner.nextInt();
               scanner.nextLine();
               switch (select) {
                    case 1 -> loginStuent();
                    case 2 -> signup();
                    case 3 -> System.out.println("exit");
                    default -> System.out.println("UnValid Select :|");
               }
          } catch (Exception e) {
               //  e.printStackTrace();
               System.out.println("!!!WRONG!!!");
          }

     }


     private static void signup() {
          System.out.println("-------->   Please fill out the registration form    <-----------");
          System.out.println("firstname:");
          String firstname = scanner.nextLine();
          System.out.println("lastname:");
          String lastname = scanner.nextLine();
          System.out.println("mothername:");
          String fathername = scanner.nextLine();
          System.out.println("fathername:");
          String mothername = scanner.nextLine();
          System.out.println("nationalIdNumber:");
          String nationalIdNumber = scanner.next();
          System.out.println("nationalCode:");
          String nationalCode = validationNationalNum();
          System.out.println("birthday Date:");
          String date = scanner.next();
          LocalDate birthdayDate = addDate(date);
          System.out.println("studentNumber:");
          String studentNumber = validationStudentNum();
          System.out.println("is married ?");
          String select = scanner.next();
          boolean married = select.equals("yes");
          System.out.println("is dormitory ?");
          String selectDomitory = scanner.next();
          boolean dormitory = selectDomitory.equals("yes");
          System.out.println("universityID:");
          int id = scanner.nextInt();
          University university = new University(id);
          Student student = new Student(firstname, lastname, fathername, mothername, nationalIdNumber
                  , nationalCode, birthdayDate, studentNumber, married, dormitory, university);

          Student newStudent = ApplicationContex.getStudentServiceImpl().save(student);
          boolean existsByNationalCode = ApplicationContex
                  .getStudentServiceImpl().existsByNationalCode(nationalCode);
          if (existsByNationalCode) {
               System.out.println("NEW STUDENT SAVED :)");

               final Optional<Student> nextSignup = ApplicationContex
                       .getStudentServiceImpl()
                                           .showUsernameAndPasswodForStudentNextSignup(newStudent.getUsername());

               System.out.println("Username : " + nextSignup.get().getUsername() + "  Password : " + nextSignup.get().getPassword());

               saveEducationStudent(newStudent);
          } else {
               System.out.println("NEW STUDENT DON'T SAVED :(");
          }
     }

     public static void loginStuent() {
          boolean isTrue = true;
          while (isTrue) {
               System.out.println("Enter username :");
               String username = scanner.next();
               boolean existsByUsername = ApplicationContex
                       .getStudentServiceImpl().existsByUsername(username);
               if (!existsByUsername) {
                    System.out.println("DON'T find username !!!");
               }
               System.out.println("Enter Password : ");
               String password = scanner.next();
               optionalStudent = ApplicationContex.getStudentServiceImpl().login(username, password);
               if (optionalStudent.isEmpty()) {
                    System.out.println("username and password UnCorrect !!!!\n");
                    System.out.println("Please Again ... ");
               } else {
                    System.out.println("Do you save new education inforamtion? ( y = Yes , n = No)");
                    String select = scanner.next();
                    if (select.equals("y")) {
                         saveEducationStudent(studentEntity);
                    }
                    if (optionalStudent.isPresent()) {
                         LoanMenu.openMenuStudent();
                         studentEntity = optionalStudent.get();
                         isTrue = false;
                    }
               }
          }
     }

     private static void saveEducationStudent(Student student) {
          System.out.println("--------->    Please fill out the Education Information form    <---------");
          System.out.println("enteringYear");
          String enteringyear = scanner.next();
          LocalDate date = addDate(enteringyear);
          System.out.println("Semester Number:");
          int semesterNumber = scanner.nextInt();
          System.out.println("Degree :");
          Degree degree = Degree.valueOf(scanner.next());
          University university = new University(student.getUniversity().getId());
          Semester semester = new Semester(semesterNumber, date, degree, student, university);
          ApplicationContex.getSemesterServiceImpl().save(semester);
          System.out.println("EDUCTION INFORMATION SAVED :)\n");
     }
}
