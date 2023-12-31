package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.Semester;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.repository.SemesterRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Optional;

public class SemesterRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Semester> implements SemesterRepository {
     public SemesterRepositoryImpl(EntityManager entityManager) {
          super(entityManager);
     }

     @Override
     public Class<Semester> getEntityClass() {
          return Semester.class;
     }

     @Override
     public Optional<Semester> findSemesterByStudentId(Student student) {
          TypedQuery<Semester> semesterTypedQuery = entityManager
                  .createQuery("SELECT s FROM Semester s WHERE" +
                          " s.student =:student" +
                                  " AND s.id=:id"
                          , Semester.class)
                  .setParameter("student", student)
                  .setParameter("id", maxRecordSemsterNumber(student))
                 ;
          return Optional.ofNullable(semesterTypedQuery.getSingleResult());
     }

     @Override
     public Integer maxRecordSemsterNumber(Student student) {
          TypedQuery<Integer> max = entityManager.createQuery(
                          "SELECT MAX (s.id) FROM Semester s " +
                                  "WHERE s.student=:student", Integer.class)
                  .setParameter("student", student);
          return max.getSingleResult();

     }


}
