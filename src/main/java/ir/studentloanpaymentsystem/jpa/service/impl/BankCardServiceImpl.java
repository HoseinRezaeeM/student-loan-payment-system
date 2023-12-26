package ir.studentloanpaymentsystem.jpa.service.impl;

import ir.studentloanpaymentsystem.jpa.base.service.impl.BaseEntityServiceImpl;
import ir.studentloanpaymentsystem.jpa.domin.BankCard;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.repository.BankCardRepository;
import ir.studentloanpaymentsystem.jpa.service.BankCardService;

public class BankCardServiceImpl extends BaseEntityServiceImpl<Integer, BankCard, BankCardRepository> implements BankCardService {
    public BankCardServiceImpl(BankCardRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean existsByNumberCard(String numberCard) {
        return baseRepository.existsByNumberCard(numberCard);
    }

    @Override
    public boolean existBanCardByNumberCardAndCcvAndExpirationDate(Student student,String numberCard, String cvv, String expirationDate) {
        return baseRepository.existBanCardByNumberCardAndCcvAndExpirationDate(student,numberCard,cvv,expirationDate);
    }

    @Override
    public boolean hasBankCardForStudent(Student student) {
        return baseRepository.hasBankCardForStudent(student);
    }
}
