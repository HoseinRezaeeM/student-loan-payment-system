package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.LoanType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan extends BaseEntity<Integer> {
    @Enumerated(value = EnumType.STRING)
    LoanType loanType;
    LocalDate loanDate;
    Double amount;
    @ManyToOne
    Student student;
    @ManyToOne
    Semester semester;

    public Loan(Integer integer) {
        super(integer);
    }
}
