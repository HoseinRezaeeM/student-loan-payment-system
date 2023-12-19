package applicationtest;

import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;
import ir.studentloanpaymentsystem.jpa.util.EntityManagerFactoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

class BankCardRepositoryImplTest {
     EntityManager entityManager;

     @BeforeEach
     void create(){
          entityManager = EntityManagerFactoryProvider
                  .getEntityManagerFactory().createEntityManager();
     }

     @Test
     void existsByNumberCard() {
          final boolean existsByNumberCard = ApplicationContex
                  .getBankCardServiceImpl().existsByNumberCard("5452421564582154");
          Assertions.assertTrue(existsByNumberCard);

     }

     @Test
     void existBanCardByNumberCardAndCcvAndExpirationDate() {
          final boolean card = ApplicationContex
                  .getBankCardServiceImpl()
                  .existBanCardByNumberCardAndCcvAndExpirationDate
                          ("5452421564582154", "1258", "1406/02/07");
          Assertions.assertTrue(card);
     }

     @Test
     void hasBankCardForStudent() {
          final boolean cardForStudent = ApplicationContex
                  .getBankCardServiceImpl().hasBankCardForStudent(new Student(15));
          Assertions.assertTrue(cardForStudent);
     }
}