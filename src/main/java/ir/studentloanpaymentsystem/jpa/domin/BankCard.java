package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.BankType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankCard extends BaseEntity<Integer> {
    @Enumerated(value = EnumType.STRING)
    BankType bankType;
    String numberCard;
    String expirationDate;
    String cvv2;
    @ManyToOne
    Student student;

}
