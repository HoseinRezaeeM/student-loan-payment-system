package applicationtest;

import ir.studentloanpaymentsystem.jpa.domin.Installment;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;
import ir.studentloanpaymentsystem.jpa.util.ApplicationContex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class InstallmentRepositoryImplTest {


     @Test
     void findUnPaidInstallment() {
          final List<Installment> unPaidInstallment = ApplicationContex.getInstallmentServiceImpl()
                  .findUnPaidInstallment(new Student(15), new Loan(4103),InstallmentStatus.UnPaid);
                  Assertions.assertNotNull(unPaidInstallment);
     }

     @Test
     void findByStudentId() {
          final Optional<Semester> studentId = ApplicationContex.getSemesterServiceImpl().findSemesterByStudentId(new Student(15));
          Assertions.assertNotNull(studentId);
     }
}