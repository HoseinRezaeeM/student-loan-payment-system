package ir.studentloanpaymentsystem.jpa.repository;

import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.domin.Student;

import java.util.Optional;

public interface StudentRepository extends BaseEntityRepository<Integer, Student> {

    Optional<Student> login(String username,String password);

    boolean existsByUsername(String username);

    Optional<Student> showUsernameAndPasswodForStudentNextSignup(String username);

    boolean existsByNationalCode(String nationalCode);
}
