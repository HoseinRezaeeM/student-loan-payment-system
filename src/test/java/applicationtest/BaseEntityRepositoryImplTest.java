package applicationtest;

import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.University;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;
import ir.studentloanpaymentsystem.jpa.util.EntityManagerFactoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;


class BaseEntityRepositoryImplTest {

     EntityManager entityManager;

     @BeforeEach
     void createObject() {
          entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
     }

     @Test
     void save() {
          Student student =new Student("Ali", "yari", "mohamad","zahra",
                  "0021025","0021025363", LocalDate.now(),"4455245",
                  true,true,new University(1));
          ApplicationContex.getStudentServiceImpl().save(student);
          boolean contains = ApplicationContex.getStudentServiceImpl().existsByUsername("12547");
          Assertions
                  .assertTrue(contains);
     }

     @Test
     void update() {
          Student student = new Student();
          Student newStudent =new Student("Ali", "yari", "mohamad","zahra",
                  "0021025","0021025363", LocalDate.now(),"4455245",
                  true,true,new University(1));
          ApplicationContex.getStudentServiceImpl().update(newStudent,4164);
          final Optional<Student> optionalStudent = ApplicationContex.getStudentServiceImpl().findById(4164);
          Assertions
                  .assertEquals(newStudent.getFirstname(),optionalStudent.get().getFirstname());
     }

     @Test
     void deleteById() {
          ApplicationContex.getStudentServiceImpl().deleteById(4166);
          final Optional<Student> optionalStudent = ApplicationContex.getStudentServiceImpl().findById(4166);
          Assertions.assertTrue(optionalStudent.isEmpty());
     }

     @Test
     void findAll() {
          final Collection<Student> all = ApplicationContex.getStudentServiceImpl().findAll();
          Assertions.assertNotNull(all);
     }
}