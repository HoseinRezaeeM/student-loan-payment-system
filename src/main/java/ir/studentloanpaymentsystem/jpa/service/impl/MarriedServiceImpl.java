package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.Married;
import ir.studentloanpaymentsystem.jpa.repository.MarriedRepository;
import ir.studentloanpaymentsystem.jpa.service.MarriedService;

public class MarriedServiceImpl extends BaseEntityServiceImpl<Integer, Married, MarriedRepository> implements MarriedService {
    public MarriedServiceImpl(MarriedRepository baseRepository) {
        super(baseRepository);
    }
}
