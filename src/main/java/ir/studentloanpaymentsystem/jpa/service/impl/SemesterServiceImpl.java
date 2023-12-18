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
    public Optional<Semester> findSemesterByStudentId(Student student) {
        return baseRepository.findSemesterByStudentId(student);
    }

     @Override
     public Integer maxRecordSemsterNumber(Student student) {
          return baseRepository.maxRecordSemsterNumber(student);
     }



}
