package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.repository.StudentRepository;
import ir.studentloanpaymentsystem.jpa.service.StudentService;

import java.util.Optional;

public class StudentServiceImpl  extends BaseEntityServiceImpl<Integer, Student, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Optional<Student> login(String username, String password) {
        return baseRepository.login(username,password);
    }

    @Override
    public boolean existsByUsername(String username) {
        return baseRepository.existsByUsername(username);
    }

    @Override
    public Optional<Student> showUsernameAndPasswodForStudentNextSignup(String username) {
        return baseRepository.showUsernameAndPasswodForStudentNextSignup(username);
    }

    @Override
    public boolean existsByNationalCode(String nationalCode) {
        return baseRepository.existsByNationalCode(nationalCode);
    }
}
