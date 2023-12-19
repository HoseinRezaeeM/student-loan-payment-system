package applicationtest;

import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class StudentRepositoryImplTest {

    @Test
    void login() {
         final Optional<Student> login = ApplicationContex.getStudentServiceImpl().login("12547", "hE%6xQZJ");
         Assertions.assertNotNull(login);
    }

    @Test
    void existsByUsername() {
         final boolean username = ApplicationContex.getStudentServiceImpl().existsByUsername("12547");
         Assertions.assertTrue(username );
    }
}