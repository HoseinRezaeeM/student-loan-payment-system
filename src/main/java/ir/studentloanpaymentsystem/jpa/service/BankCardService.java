package ir.studentloanpaymentsystem.jpa.service;

import ir.studentloanpaymentsystem.jpa.base.service.BaseEntityService;
import ir.studentloanpaymentsystem.jpa.domin.BankCard;
import ir.studentloanpaymentsystem.jpa.domin.Student;


public interface BankCardService extends BaseEntityService<Integer, BankCard> {
    boolean existsByNumberCard(String numberCard);

    boolean existBanCardByNumberCardAndCcvAndExpirationDate(Student student,String numberCard,String cvv,String expirationDate);

    boolean hasBankCardForStudent(Student student);
}
