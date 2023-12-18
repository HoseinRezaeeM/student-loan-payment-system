package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.Installment;

import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;
import ir.studentloanpaymentsystem.jpa.repository.InstallmentRepository;
import ir.studentloanpaymentsystem.jpa.service.InstallmentService;

import java.util.List;
import java.util.Optional;

public class InstallmentServiceImpl extends BaseEntityServiceImpl<Integer, Installment, InstallmentRepository> implements InstallmentService {
    public InstallmentServiceImpl(InstallmentRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Installment> findPaidInstallments(Student student, Loan loan, InstallmentStatus status) {
        return baseRepository.findPaidInstallments(student,loan,status);
    }

    @Override
    public List<Installment> findUnPaidInstallment(Student student, Loan loan,InstallmentStatus status) {
        return baseRepository.findUnPaidInstallment(student,loan,status);
    }

    @Override
    public Optional<Installment> findByStudentId(int id,Student student) {
        return baseRepository.findByStudentId(id,student);
    }

}
