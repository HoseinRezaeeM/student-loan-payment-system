package ir.studentloanpaymentsystem.jpa.menu;

import ir.studentloanpaymentsystem.jpa.domin.*;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.*;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;


import java.time.LocalDate;
import java.util.Optional;

import static ir.studentloanpaymentsystem.jpa.menu.BaseMenu.scanner;
import static ir.studentloanpaymentsystem.jpa.menu.LoanMenu.studentEntity;
import static ir.studentloanpaymentsystem.jpa.util.DateApplication.DATENOWAPLICATION;

public class RegisterLoanMenu {

     static Optional<Semester> semester = ApplicationContex.
             getSemesterServiceImpl().findSemesterByStudentId(studentEntity);

     static Semester semesterStudent = semester.get();

     static void saveTuitionLoan() {
          if (studentEntity.getUniversity().getUniversityType().equals(UniversityType.DolatiDayUniversity)) {
               System.out.println("<<< SORRY You will not receive a loan " +
                       "because your University is Daily :) >>>\n");
          } else {
               boolean existOneLoanPaymentPerSemester = ApplicationContex.getLoanServiceImpl()
                       .existOneLoanPaymentPerSemester(studentEntity, semesterStudent.getSemesterNumber(), semesterStudent.getDegree(),LoanType.Tuition);
               if (existOneLoanPaymentPerSemester) {
                    System.out.println("<<<  You will not be granted a eduction loan " +
                            "because you have already received a education loan in the current semester :)  >>>\n");
               } else {
                    Loan loan = null;
                    Degree degree = semesterStudent.getDegree();
                    if (degree.equals(Degree.Associate) || degree.equals(Degree.Bachelor) || degree.equals(Degree.NoncontiguousBachelor)) {
                         loan = new Loan(LoanType.Tuition, DATENOWAPLICATION, 1_300_000.00, studentEntity,semesterStudent);
                    } else if (degree.equals(Degree.Master) || degree.equals(Degree.NoncontiguousMaster) ||
                            degree.equals(Degree.Doctor) || degree.equals(Degree.ProfessionalDoctor)) {
                         loan = new Loan(LoanType.Tuition, DATENOWAPLICATION, 2_600_000.00, studentEntity,semesterStudent);
                    } else if (degree.equals(Degree.NonContinuousSpecializedDoctor)) {
                         loan = new Loan(LoanType.Tuition, DATENOWAPLICATION, 6_500_000.00, studentEntity,semesterStudent);
                    }
                    Loan saveLoan = ApplicationContex.getLoanServiceImpl().save(loan);
                    calculateInstallmentsStaggeredMannerBasedOnYear(saveLoan.getAmount(),saveLoan);
                    System.out.println("<<< The loan was deposited into your account ;) >>>\n");

               }
          }
     }


     static void saveEducationLoan() {
          boolean existOneLoanPaymentPerSemester = ApplicationContex.getLoanServiceImpl()
                  .existOneLoanPaymentPerSemester(studentEntity, semesterStudent.getSemesterNumber(), semesterStudent.getDegree(),LoanType.Education);
          if (existOneLoanPaymentPerSemester) {
               System.out.println("<<< You will not be granted a eduction loan " +
                       "because you have already received a education loan in the current semester :) >>>\n");
          } else {
               Loan loan = null;
               Degree degree = semesterStudent.getDegree();
               if (degree.equals(Degree.Associate) || degree.equals(Degree.Bachelor) || degree.equals(Degree.NoncontiguousBachelor)) {
                    loan = new Loan(LoanType.Education, DATENOWAPLICATION, 1_900_000.00, studentEntity,semesterStudent);
               } else if (degree.equals(Degree.Master) || degree.equals(Degree.NoncontiguousMaster) ||
                       degree.equals(Degree.Doctor) || degree.equals(Degree.ProfessionalDoctor)) {
                    loan = new Loan(LoanType.Education, DATENOWAPLICATION, 2_250_000.00, studentEntity,semesterStudent);
               } else if (degree.equals(Degree.NonContinuousSpecializedDoctor)) {
                    loan = new Loan(LoanType.Education, DATENOWAPLICATION, 2_600_000.00, studentEntity,semesterStudent);
               }
               Loan saveLoan = ApplicationContex.getLoanServiceImpl().save(loan);
               calculateInstallmentsStaggeredMannerBasedOnYear(saveLoan.getAmount(),saveLoan);
               System.out.println("<<< The loan was deposited into your account ;)  >>>\n");
          }
     }


     static void saveHousingLoan() {

          boolean exist = ApplicationContex
                  .getLoanServiceImpl().exist(studentEntity, semesterStudent.getDegree());

          if (studentEntity.getDormitory().equals(true) && studentEntity.getMarried().equals(false)) {
               System.out.println("<<< SORRY You will not receive a loan because You aren't Domotiry or You are  :) ");
          } else {
               if (exist) {
                    System.out.println("<<< SORRY You will not receive a loan " +
                            "because You receive loan current Degree :) >>>\n");
               } else {
                    System.out.println("------- Please Enter Maried Information -----\n");
                    System.out.println("WifeId:");
                    int wifeId = scanner.nextInt();
                    Student wife = new Student(wifeId);
                    boolean existWife = ApplicationContex
                            .getLoanServiceImpl().existWifeTakeHousingLoan(wife, semesterStudent.getDegree());
                    if (existWife) {
                         System.out.println("<<< SORRY You will not receive a loan " +
                                 " Because your wife received a loan :) >>>\n");
                    }else {

                         System.out.println("Addrress:");
                         String address = scanner.next();
                         System.out.println("rental Number:");
                         String rental = scanner.next();
                         Married married = new Married(address, rental, studentEntity, wife, null);
                         ApplicationContex.getMarriedServiceImpl().save(married);
                         Optional<Semester> studentWife = ApplicationContex
                                 .getSemesterServiceImpl().findSemesterByStudentId(wife);

                         Loan loan;
                         if (studentEntity.getUniversity().getCity().equals("Tehran")) {
                              loan = new Loan(LoanType.Housing, DATENOWAPLICATION, 32_000_000.00, studentEntity, semesterStudent);
                         } else if (isCharacterInEnum(studentEntity.getUniversity().getCity(), Metropolis.class)) {
                              loan = new Loan(LoanType.Housing, DATENOWAPLICATION, 26_000_000.00, studentEntity, semesterStudent);
                         } else {
                              loan = new Loan(LoanType.Housing, DATENOWAPLICATION, 19_500_000.00, studentEntity, semesterStudent);
                         }

                         Loan saveLoan = ApplicationContex.getLoanServiceImpl().save(loan);
                         Loan loan1 = new Loan(saveLoan.getId());
                         Married updateMarried = new Married(address, rental, studentEntity, wife, loan1);
                         ApplicationContex.getMarriedServiceImpl().update(updateMarried, married.getId());
                         calculateInstallmentsStaggeredMannerBasedOnYear(saveLoan.getAmount(), saveLoan);
                         System.out.println("<< The loan was deposited into your account ;) >>\n");
                    }
               }
          }
     }
     public static <E extends Enum<E>> boolean isCharacterInEnum(String city, Class<E> enumClass) {
          for (Enum<E> constant : enumClass.getEnumConstants()) {
               if (constant.name().equals(city)) {
                    return true;
               }
          }
          return false;
     }



     private static void calculateInstallmentsStaggeredMannerBasedOnYear(Double loanAmount,Loan loan) {
          double interestRate = 0.04;
          int numberOfYears = 5;
          int numberOfMonths = numberOfYears * 12;
          double loanAmountByRate = loanAmount + loanAmount * interestRate;
          double installmentAmount = (loanAmountByRate / numberOfMonths);
          int installmentNumber = 1;


          LocalDate dueDate = null;
          Degree degree = semesterStudent.getDegree();
          if (degree.equals(Degree.Bachelor) || degree.equals(Degree.NoncontiguousBachelor)) {
               dueDate = DATENOWAPLICATION.plusYears(4);

          } else if (degree.equals(Degree.Associate) || degree.equals(Degree.NoncontiguousMaster)) {
              dueDate = DATENOWAPLICATION.plusYears(2);

          } else if (degree.equals(Degree.Master)) {
               dueDate = DATENOWAPLICATION.plusYears(6);

          } else if (degree.equals(Degree.NonContinuousSpecializedDoctor) ||
                  degree.equals(Degree.Doctor) || degree.equals(Degree.ProfessionalDoctor)) {
               dueDate = DATENOWAPLICATION.plusYears(5);
          }
          for (int i = 1; i <= numberOfMonths; i++) {
               Installment installment = new Installment(installmentNumber, installmentAmount, dueDate,
                       null, InstallmentStatus.UnPaid, studentEntity,loan);
               ApplicationContex.getInstallmentServiceImpl().save(installment);
               if (i % 12 == 0) {
                    installmentAmount *= 2;
               }
               dueDate = dueDate.plusMonths(1);
               installmentNumber++;
          }
     }
}







