package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.LoanType;
import ir.studentloanpaymentsystem.jpa.repository.LoanRepository;
import ir.studentloanpaymentsystem.jpa.service.LoanService;

import java.time.LocalDate;

public class LoanServiceImpl  extends BaseEntityServiceImpl<Integer, Loan, LoanRepository> implements LoanService {
    public LoanServiceImpl(LoanRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean existOneLoanPaymentPerSemester(Student student, int semesterNumber, Degree degree, LoanType loanType) {
        return baseRepository.existOneLoanPaymentPerSemester(student,semesterNumber,degree,loanType);
    }

    @Override
    public boolean exist(Student student, Degree degree) {
        return baseRepository.exist(student,degree);
    }

     @Override
     public LocalDate maxRecordEntriesDate(Student student) {
          return baseRepository.maxRecordEntriesDate(student);
     }

     @Override
     public boolean existWifeTakeHousingLoan(Student stuent, Degree degree) {
         return baseRepository.existWifeTakeHousingLoan(stuent,degree);
     }
}
