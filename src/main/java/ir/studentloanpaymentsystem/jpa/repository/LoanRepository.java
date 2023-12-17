package ir.studentloanpaymentsystem.jpa.repository;

import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.LoanType;

import java.time.LocalDate;

public interface LoanRepository extends BaseEntityRepository<Integer, Loan> {
    boolean existOneLoanPaymentPerSemester(Student student, int semesterNumber, Degree degree, LoanType loanType);

    boolean exist(Student student,Degree degree);


     boolean existWifeTakeHousingLoan(Student stuent,Degree degree);

     LocalDate maxRecordEntriesDate(Student student);
}
