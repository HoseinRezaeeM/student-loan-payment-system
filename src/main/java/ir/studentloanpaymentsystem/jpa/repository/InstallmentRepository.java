package ir.studentloanpaymentsystem.jpa.repository;

import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.domin.Installment;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;

import java.util.List;
import java.util.Optional;

public interface InstallmentRepository extends BaseEntityRepository<Integer, Installment> {

    List<Installment> findPaidInstallments(Student student, Loan loan,InstallmentStatus status);

    List<Installment> findUnPaidInstallment(Student student, Loan loan,InstallmentStatus status);

    Optional<Installment> findByStudentId(int id,Student student);


     Double sumAllLaonAmountPerStudent(Student student);
}
