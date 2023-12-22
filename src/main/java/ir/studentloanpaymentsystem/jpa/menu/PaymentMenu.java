package ir.studentloanpaymentsystem.jpa.menu;

import ir.studentloanpaymentsystem.jpa.domin.Installment;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static ir.studentloanpaymentsystem.jpa.menu.BaseMenu.scanner;
import static ir.studentloanpaymentsystem.jpa.menu.LoanMenu.openMenuStudent;
import static ir.studentloanpaymentsystem.jpa.menu.LoanMenu.studentEntity;
import static ir.studentloanpaymentsystem.jpa.menu.RegisterLoanMenu.semesterStudent;
import static ir.studentloanpaymentsystem.jpa.util.DateApplication.DATENOWAPLICATION;
import static ir.studentloanpaymentsystem.jpa.validation.SignupValidation.validationBankCardNum;

@SuppressWarnings("unused")
public class PaymentMenu {

     static void checkStudentGraduatedForRepaymentInstallment() {
          LocalDate entriesYear = semesterStudent.getEntriesYear();
          Degree degree = semesterStudent.getDegree();

          if (degree.equals(Degree.Bachelor) || degree.equals(Degree.NoncontiguousBachelor)) {
               LocalDate plusYears = entriesYear.plusYears(4);
               if (DATENOWAPLICATION.isAfter(plusYears)) {
                    payImstallmentByStudent();

               } else {
                    System.out.println("Repayment have NOT been activated  Because You have Not graduated :) >>\n");
               }
          } else if (degree.equals(Degree.Associate) || degree.equals(Degree.NoncontiguousMaster)) {
               LocalDate plusYears = entriesYear.plusYears(2);
               if (DATENOWAPLICATION.isAfter(plusYears)) {
                    payImstallmentByStudent();
               } else {
                    System.out.println(" << Repayment have NOT been activated Because You have Not graduated :) >>\n");
               }
          } else if (degree.equals(Degree.Master)) {
               LocalDate plusYears = entriesYear.plusYears(6);
               if (DATENOWAPLICATION.isAfter(plusYears)) {
                    payImstallmentByStudent();
               } else {
                    System.out.println(" << Repayment have NOT been activated  Because You have Not graduated :) >> \n");
               }
          } else if (degree.equals(Degree.NonContinuousSpecializedDoctor) || degree.equals(Degree.Doctor) || degree.equals(Degree.ProfessionalDoctor)) {
               LocalDate plusYears = entriesYear.plusYears(5);
               if (DATENOWAPLICATION.isAfter(plusYears)) {
                    payImstallmentByStudent();
               } else {
                    System.out.println("<< Repayment have NOT been activated  Because You have graduated :) >>\n");
               }
          }
     }

     static void payImstallmentByStudent() {
          boolean isTrue = true;
          while (isTrue) {
               System.out.println("------------------------------------------");
               System.out.println("|       Installment Repayment Menu       |");
               System.out.println("----------------------------------------\n");
               System.out.println("1. Paid Installments ");
               System.out.println("2. UnPaid Installments");
               System.out.println("3. Payment Installment");
               System.out.println("4. return pervious menu");
               System.out.println("5. Exit");
               System.out.println("Enter your Select:");
               int select = scanner.nextInt();
               scanner.nextLine();
               switch (select) {
                    case 1 -> findPaidInstallment();
                    case 2 -> findUnPaidInstallment();
                    case 3 -> paymentInstallment();
                    case 4 -> openMenuStudent();
                    case 5 -> {
                         System.out.println("Good Bye :)");
                         isTrue = false;
                    }
                    default -> System.out.println("select Unvalid!!!");
               }
          }
     }

     private static void findUnPaidInstallment() {
          System.out.println("Loan Id :");
          int loanId = scanner.nextInt();
          Loan loan = new Loan(loanId);

          List<Installment> unPaidInstallment = ApplicationContex
                  .getInstallmentServiceImpl()
                  .findUnPaidInstallment(studentEntity, loan, InstallmentStatus.UnPaid);
          if (unPaidInstallment.isEmpty()) {
               System.out.println("<<< Not exist Installments Unpaid >>> ");
          } else {
               unPaidInstallment.forEach(Installment::toShow);
          }
     }


     private static void findPaidInstallment() {
          System.out.println("Loan Id:");
          int loanId = scanner.nextInt();
          Loan loan = new Loan(loanId);
          List<Installment> paidInstallment = ApplicationContex
                  .getInstallmentServiceImpl()
                  .findPaidInstallments(studentEntity, loan, InstallmentStatus.Paid);

          if (paidInstallment.isEmpty()) {
               System.out.println("<<< Not exist Installments Paid >>>");
          } else {
               paidInstallment.forEach(System.out::println);
          }
     }

     private static void paymentInstallment() {
          while (true) {
               System.out.println("-----------------------------------------------------------------");
               System.out.println("|     Enter your bank card information for Payment Installment  |");
               System.out.println("---------------------------------------------------------------\n");
               System.out.println("NumberCard:");
               String numberCard = validationBankCardNum();
               System.out.println("CVV2 :");
               String cvv2 = scanner.next();
               System.out.println("ExpirationDate");
               String expirationData = scanner.next();
               boolean card = ApplicationContex.getBankCardServiceImpl()
                       .existBanCardByNumberCardAndCcvAndExpirationDate(numberCard, cvv2, expirationData);
               if (card) {
                    System.out.println("Installment Id:");
                    int inatallmentId = scanner.nextInt();
                    System.out.println("Loan Id:");
                    int loanId = scanner.nextInt();
                    Loan loan = new Loan(loanId);
                    Optional<Installment> installmentOptional = ApplicationContex
                            .getInstallmentServiceImpl().findByStudentId(inatallmentId, studentEntity);

                    Installment installment = new Installment(inatallmentId, installmentOptional.get().getInstallmentNumber()
                                    , installmentOptional.get().getAmount(), installmentOptional.get().getDueDate()
                                    , DATENOWAPLICATION, InstallmentStatus.Paid, studentEntity,loan);

                    ApplicationContex.getInstallmentServiceImpl().update(installment, inatallmentId);
                    System.out.println("The installment was paid ;)\n");
                    break;
               } else {
                    System.out.println("Bank card is not available :|\n");
               }
          }
     }
}
