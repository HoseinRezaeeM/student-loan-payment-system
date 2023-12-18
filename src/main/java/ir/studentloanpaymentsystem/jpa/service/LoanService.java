package ir.studentloanpaymentsystem.jpa.service;

import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.LoanType;

import java.time.LocalDate;


public interface LoanService extends BaseEntityService<Integer, Loan> {
    boolean existOneLoanPaymentPerSemester(Student student, int semesterNumber, Degree degree, LoanType loanType);
    boolean exist(Student student,Degree degree);
    LocalDate maxRecordEntriesDate(Student student);
     boolean existWifeTakeHousingLoan(Student stuent,Degree degree);
}
