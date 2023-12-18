package ir.studentloanpaymentsystem.jpa.repository;

import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;

import java.time.LocalDate;
import java.util.Optional;

public interface SemesterRepository extends BaseEntityRepository<Integer, Semester> {

    Optional<Semester> findSemesterByStudentId(Student student);

    Integer maxRecordSemsterNumber(Student student);


}
