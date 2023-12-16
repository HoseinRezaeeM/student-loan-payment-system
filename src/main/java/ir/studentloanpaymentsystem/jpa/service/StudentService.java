package ir.studentloanpaymentsystem.jpa.service;

import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;
import ir.studentloanpaymentsystem.jpa.domin.Student;

import java.util.Optional;

public interface StudentService extends BaseEntityService<Integer, Student> {
    Optional<Student> login(String username, String password);

    boolean existsByUsername(String username);

    Optional<Student> showUsernameAndPasswodForStudentNextSignup(String usename);

    boolean existsByNationalCode(String nationalCode);
}
