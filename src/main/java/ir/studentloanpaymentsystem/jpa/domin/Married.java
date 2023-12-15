package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Married extends BaseEntity<Integer> {
    String address;
    String rentalNumber;
    @ManyToOne
    Student student;
    @ManyToOne
    Student wife;
    @OneToOne
    Loan loan;

    public Married(Loan loan) {
        this.loan = loan;
    }
}
