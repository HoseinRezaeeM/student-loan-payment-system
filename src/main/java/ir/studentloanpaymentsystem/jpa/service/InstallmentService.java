package ir.studentloanpaymentsystem.jpa.service;

import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;
import ir.studentloanpaymentsystem.jpa.domin.Installment;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;

import java.util.List;
import java.util.Optional;


public interface InstallmentService extends BaseEntityService<Integer, Installment> {

    List<Installment> findPaidInstallments(Student student, Loan loan, InstallmentStatus status);

    List<Installment> findUnPaidInstallment(Student student, Loan loan,InstallmentStatus status);

    Optional<Installment> findByStudentId(int id,Student student);


}
