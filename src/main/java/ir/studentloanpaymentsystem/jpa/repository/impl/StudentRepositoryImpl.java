package ir.studentloanpaymentsystem.jpa.repository.impl;

import ir.studentloanpaymentsystem.jpa.base.repository.impl.BaseEntityRepositoryImpl;
import ir.studentloanpaymentsystem.jpa.domin.Student;
import ir.studentloanpaymentsystem.jpa.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class StudentRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Student> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Optional<Student> login(String username, String password) {
        try {
            return Optional.ofNullable(
                    entityManager.createQuery("SELECT s FROM Student s"
                                    + " where s.username =: username AND s.password =: password", Student.class)
                            .setParameter("username", username)
                            .setParameter("password", password)
                            .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        TypedQuery<Long> query = entityManager
                .createQuery("SELECT COUNT (s) FROM Student s "
                                +" WHERE s.username =: username "
                        , Long.class);
        query.setParameter("username", username);

        return query.getSingleResult() > 0;
    }

    @Override
    public Optional<Student> showUsernameAndPasswodForStudentNextSignup(String username) {  //By Criteria
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery =criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        criteriaQuery.multiselect(studentRoot.get("username"),studentRoot.get("password"));
        CriteriaQuery<Student> select =criteriaQuery.select(studentRoot)
                .where(criteriaBuilder.equal(studentRoot.get("username"),username));
        Student result = entityManager.createQuery(select)
                .getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public boolean existsByNationalCode(String nationalCode) {
        TypedQuery<Long> query = entityManager
                .createQuery("SELECT COUNT (s) FROM Student s "
                                +" WHERE s.nationalCode =: nationalCode "
                        , Long.class);
        query.setParameter("nationalCode", nationalCode);
        return query.getSingleResult() > 0;
    }
}
