package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.repository.SemesterRepository;
import ir.studentloanpaymentsystem.jpa.service.SemesterService;

import java.time.LocalDate;
import java.util.Optional;

public class SemesterServiceImpl  extends BaseEntityServiceImpl<Integer, Semester, SemesterRepository> implements SemesterService {
    public SemesterServiceImpl(SemesterRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Optional<Semester> findByStudentId(Student student) {
        return baseRepository.findByStudentIdForOtherLoan(student);
    }

     @Override
     public Integer maxRecordSemsterNumber(Student student) {
          return baseRepository.maxRecordSemsterNumber(student);
     }

     @Override
     public Optional<Semester> findByStudentIdForHousingLaon(Student student, Degree degree) {
          return baseRepository.findByStudentIdForHousingLaon(student,degree);
     }

     @Override
     public LocalDate maxRecordEntriesDate(Student student) {
          return baseRepository.maxRecordEntriesDate(student);
     }

}
