package ir.studentloanpaymentsystem.jpa.domin;

import ir.studentloanpaymentsystem.jpa.base.domin.BaseEntity;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University extends BaseEntity<Integer> {
    String city;
    String universityName;
    @Enumerated(value = EnumType.STRING)
    UniversityType universityType;
    @OneToMany(mappedBy = "university")
    List<Student> studentList;
    @OneToMany(mappedBy = "university")
    List<Semester> semester;

    public University(Integer id) {
        super(id);
    }


}
