package ir.studentloanpaymentsystem.jpa.repository;

import ir.studentloanpaymentsystem.jpa.base.repository.BaseEntityRepository;
import ir.studentloanpaymentsystem.jpa.domin.BankCard;
import ir.studentloanpaymentsystem.jpa.domin.Student;

public interface BankCardRepository extends BaseEntityRepository<Integer, BankCard> {

    boolean existsByNumberCard(String numberCard);

    boolean existBanCardByNumberCardAndCcvAndExpirationDate(String numberCard,String cvv,String expirationDate);

    boolean hasBankCardForStudent(Student student);
}
