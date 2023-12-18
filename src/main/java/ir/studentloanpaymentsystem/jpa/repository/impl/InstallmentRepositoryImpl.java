package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.Installment;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;
import ir.studentloanpaymentsystem.jpa.repository.InstallmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class InstallmentRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Installment> implements InstallmentRepository {
    public InstallmentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Installment> getEntityClass() {
        return null;
    }


    @Override
    public List<Installment> findPaidInstallments(Student student, Loan loan,InstallmentStatus status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Installment> criteriaQuery = criteriaBuilder.createQuery(Installment.class);
        Root<Installment> installmentRoot = criteriaQuery.from(Installment.class);
        criteriaQuery
                .multiselect(installmentRoot.get("paymentDate"), installmentRoot.get("installmentNumber"));
        CriteriaQuery<Installment> select = criteriaQuery
                .select(installmentRoot).where(criteriaBuilder.and(criteriaBuilder.
                        equal(installmentRoot.get("student"), student), criteriaBuilder
                        .equal(installmentRoot.get("loan"), loan),criteriaBuilder
                        .equal(installmentRoot.get("status"),status)));
        return entityManager
                .createQuery(select)
                .getResultList();

    }

    @Override
    public List<Installment> findUnPaidInstallment(Student student, Loan loan,InstallmentStatus status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Installment> criteriaQuery = criteriaBuilder.createQuery(Installment.class);
        Root<Installment> installmentRoot = criteriaQuery.from(Installment.class);
        criteriaQuery
                .multiselect(installmentRoot.get("dueDate"), installmentRoot.get("installmentNumber"),installmentRoot.get("amount"));
        CriteriaQuery<Installment> select = criteriaQuery
                .select(installmentRoot).where(criteriaBuilder.and(criteriaBuilder
                        .equal(installmentRoot.get("student"), student), criteriaBuilder
                        .equal(installmentRoot.get("loan"), loan),criteriaBuilder
                        .equal(installmentRoot.get("status"),status)));
        return entityManager
                .createQuery(select)
                .getResultList();

    }

    @Override
    public Optional<Installment> findByStudentId(int id ,Student student) {
        return Optional
                .ofNullable(entityManager.createQuery("SELECT i FROM Installment i WHERE " +
                                "i.student=:student AND i.id=:id" , Installment.class)
                        .setParameter("student",student)
                        .setParameter("id",id)
                        .getSingleResult());
    }

     @Override
     public Double sumAllLaonAmountPerStudent(Student student) {
          TypedQuery<Double> typedQuery =entityManager
                  .createQuery("SELECT SUM (l.amount) FROM Loan l" +
                          " WHERE l.student=:student", Double.class)
                  .setParameter("student",student);
          return typedQuery.getSingleResult();
     }

}
