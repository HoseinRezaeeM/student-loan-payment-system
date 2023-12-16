package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.University;
import ir.studentloanpaymentsystem.jpa.repository.UniversityRepository;

import javax.persistence.EntityManager;

public class UniversityRepositoryImpl extends BaseEntityRepositoryImpl<Integer, University> implements UniversityRepository {
    public UniversityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }
}
