package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.Loan;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.Degree;
import ir.studentloanpaymentsystem.jpa.domin.enumeration.LoanType;
import ir.studentloanpaymentsystem.jpa.repository.LoanRepository;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class LoanRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Loan> implements LoanRepository {
     public LoanRepositoryImpl(EntityManager entityManager) {
          super(entityManager);
     }

     @Override
     public Class<Loan> getEntityClass() {
          return Loan.class;
     }

     @Override
     public boolean existOneLoanPaymentPerSemester(Student student, int semesterNumber, Degree degree,LoanType loanType) {
          TypedQuery<Long> typedQuery = entityManager
                  .createQuery("SELECT COUNT (l) FROM Loan l INNER JOIN  "
                          + " Semester s ON s.id=l.semester.id"
                          + " WHERE  l.student =:student"
                          + " AND s.semesterNumber=:semesterNumber"
                          + " AND s.degree =:degree" +
                          "  AND l.loanType=:loanType", Long.class)
                  .setParameter("student", student)
                  .setParameter("semesterNumber", semesterNumber)
                  .setParameter("degree", degree)
                  .setParameter("loanType",loanType);

          return typedQuery.getSingleResult() >= 1;
     }

     @Override
     public boolean exist(Student stuent, Degree degree) {
          TypedQuery<Long> typedQuery = entityManager
                  .createQuery("SELECT COUNT (l) FROM Loan l INNER JOIN " +
                          " Semester s ON l.semester.id=s.id" +
                          "  WHERE s.student =:student " +
                          "  AND s.degree=:degree" +
                          ""
                          + " AND l.loanType=:loanType", Long.class)
                  .setParameter("student", stuent)
                  .setParameter("degree", degree)
                //  .setParameter("entriesYear",maxRecordEntriesDate(stuent))
                  .setParameter("loanType", LoanType.Housing);
          return typedQuery.getSingleResult() >= 1;
     }
     @Override
     public boolean existWifeTakeHousingLoan(Student stuent,Degree degree) {
          TypedQuery<Long> typedQuery = entityManager
                  .createQuery("SELECT COUNT (l) FROM Loan l INNER JOIN " +
                          " Semester s ON l.semester.id=s.id" +
                          "  WHERE s.student =:student " +
                          "  AND s.degree=:degree" +
                          ""
                          + " AND l.loanType=:loanType", Long.class)
                  .setParameter("student", stuent)
                  .setParameter("degree",degree)
                  .setParameter("loanType", LoanType.Housing);
          return typedQuery.getSingleResult() >= 1;
     }

     @Override
     public  LocalDate maxRecordEntriesDate(Student student) {
          Query typedQuery =entityManager
                  .createQuery("SELECT MAX (s.entriesYear) FROM Semester s" +
                          " WHERE s.student=:student")
                  .setParameter("student",student);
          return (LocalDate) typedQuery.getSingleResult();
     }
}
