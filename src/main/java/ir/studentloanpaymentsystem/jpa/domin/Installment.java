package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.InstallmentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Installment extends BaseEntity<Integer> {
     @GeneratedValue(strategy = GenerationType.AUTO)
     Integer installmentNumber;
     Double amount;
     LocalDate dueDate;
     LocalDate paymentDate;
     @Enumerated(value = EnumType.STRING)
     InstallmentStatus status;
     @ManyToOne
     Student student;
     @ManyToOne
     Loan loan;


     public Installment(Integer integer) {
          super(integer);
     }

     public Installment(Integer integer, Integer installmentNumber,
                        Double amount, LocalDate dueDate, LocalDate paymentDate,
                        InstallmentStatus status, Student student,Loan loan) {
          super(integer);
          this.installmentNumber = installmentNumber;
          this.amount = amount;
          this.dueDate = dueDate;
          this.paymentDate = paymentDate;
          this.status = status;
          this.student = student;
          this.loan=loan;

     }

     @Override
     public String toString() {
          return " installmentNumber = " + installmentNumber +
                  ", amount = " + amount +
                  ", paymentData =" + paymentDate+"\n";
     }

     public void toShow() {
          System.out.println(" installmentNumber = " + installmentNumber +
                  ", amount = " + amount +
                  ", dueDate = " + dueDate +
                  "\n");
     }



}




