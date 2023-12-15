package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;

import ir.studentloanpaymentsystem.jpa.util.PasswordGenerator;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static ir.studentloanpaymentsystem.jpa.util.PasswordGenerator.generatePassword;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends BaseEntity<Integer> {
    String firstname;
    String lastname;
    String fathername;
    String mothername;
    String nationalIdNumber;
    String nationalCode;
    LocalDate birthday;
    String studentNumber;
    Boolean married;
    Boolean dormitory;
    String username;
    String password;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    List<Loan> loanList;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    List<BankCard> bankCardList;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    List<Semester> semesterList;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    List<Installment> installments;
    @ManyToOne
    University university;

    public Student(String firstname, String lastname, String fathername, String mothername, String nationalIdNumber,
                   String nationalCode, LocalDate birthday, String studentNumber, Boolean married, Boolean dormitory,
                   University university) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fathername = fathername;
        this.mothername = mothername;
        this.nationalIdNumber = nationalIdNumber;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.studentNumber = studentNumber;
        this.married = married;
        this.dormitory = dormitory;
        this.university = university;
        this.username =nationalCode;
        this.password =generatePassword();
    }

    public Student(Integer id) {
        super(id);
    }
}

