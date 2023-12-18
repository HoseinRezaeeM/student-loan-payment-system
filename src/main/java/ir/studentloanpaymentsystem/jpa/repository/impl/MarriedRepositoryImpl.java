package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.Married;
import ir.studentloanpaymentsystem.jpa.repository.MarriedRepository;

import javax.persistence.EntityManager;

public class MarriedRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Married> implements MarriedRepository {
    public MarriedRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Married> getEntityClass() {
        return Married.class;
    }
}
