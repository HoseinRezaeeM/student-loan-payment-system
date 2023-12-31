package ir.studentloanpaymentsystem.jpa.service;

import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;
import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;

import java.time.LocalDate;
import java.util.Optional;


public interface SemesterService extends BaseEntityService<Integer, Semester> {
     Optional<Semester> findSemesterByStudentId(Student student);

     Integer maxRecordSemsterNumber(Student student);

}
