package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.BankCard;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.repository.BankCardRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BankCardRepositoryImpl extends BaseEntityRepositoryImpl<Integer, BankCard> implements BankCardRepository {
    public BankCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<BankCard> getEntityClass() {
        return null;
    }

    @Override
    public boolean existsByNumberCard(String numberCard) {
        TypedQuery<Long> typedQuery = entityManager
                .createQuery("SELECT COUNT (b) FROM BankCard b" +
                        " WHERE b.numberCard =: numberCard", Long.class)
                .setParameter("numberCard", numberCard);
        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public boolean existBanCardByNumberCardAndCcvAndExpirationDate(String numberCard, String cvv, String expirationDate) {
        TypedQuery<Long> typedQuery = entityManager
                .createQuery("SELECT COUNT (b) FROM BankCard b" +
                        " WHERE b.numberCard =: numberCard AND b.cvv2 =:cvv2 AND b.expirationDate =: expirationDate", Long.class)
                .setParameter("numberCard", numberCard)
                .setParameter("cvv2",cvv)
                .setParameter("expirationDate",expirationDate);
        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public boolean hasBankCardForStudent(Student student) {
        TypedQuery<Long> typedQuery =entityManager
                .createQuery("SELECT COUNT (b) FROM BankCard b " +
                        "WHERE b.student =:student", Long.class)
                .setParameter("student",student);
        return typedQuery.getSingleResult() >= 1;
    }
}
