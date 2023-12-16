package ir.studentloanpaymentsystem.jpa.validation;

import java.util.regex.Pattern;

import static ir.studentloanpaymentsystem.jpa.menu.BaseMenu.scanner;

public class SignupValidation {

     public static boolean validationNationalCode(String nationalCode){
          Pattern pattern =Pattern.compile("^[0-9]{10}$");
          return nationalCode.matches(pattern.pattern());
     }
     public static String validationNationalNum() {
          String nationalCode = null;
          boolean isTrue = true;
          while (isTrue) {

               nationalCode = scanner.next();
               if (validationNationalCode(nationalCode)) {
                    isTrue = false;
               } else {
                    System.out.println("Enter validation NationalCode!!!!");
               }
          }
          return nationalCode;
     }

     public static boolean validationStudentNumber(String studentNumber){
          Pattern pattern =Pattern.compile("^[0-9]{8}$");
          return studentNumber.matches(pattern.pattern());
     }

     public static String validationStudentNum() {
          String studentNum = null;
          boolean isTrue = true;
          while (isTrue) {

               studentNum = scanner.next();
               if (validationStudentNumber(studentNum)) {
                    isTrue = false;
               } else {
                    System.out.println("Enter validation StudentNumber!!!!");
               }
          }
          return studentNum;
     }

     public static boolean validationBankCardNumber(String studentNumber){
          Pattern pattern =Pattern.compile("^[0-9]{8}$");
          return studentNumber.matches(pattern.pattern());
     }

     public static String validationBankCardNum() {
          String bankCard = null;
          boolean isTrue = true;
          while (isTrue) {

               bankCard = scanner.next();
               if (validationBankCardNumber(bankCard)) {
                    isTrue = false;
               } else {
                    System.out.println("Enter validation NationalCode!!!!");
               }
          }
          return bankCard;
     }

}
