package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.University;
import ir.studentloanpaymentsystem.jpa.repository.UniversityRepository;
import ir.studentloanpaymentsystem.jpa.service.UniversityService;

public class UniversityServiceImpl extends BaseEntityServiceImpl<Integer, University, UniversityRepository> implements UniversityService {
    public UniversityServiceImpl(UniversityRepository baseRepository) {
        super(baseRepository);
    }
}
