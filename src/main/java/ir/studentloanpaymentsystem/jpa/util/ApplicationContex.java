package ir.studentloanpaymentsystem.jpa.util;

import ir.studentloanpaymentsystem.jpa.repository.*;
import ir.studentloanpaymentsystem.jpa.repository.impl.*;
import ir.studentloanpaymentsystem.jpa.service.*;
import ir.studentloanpaymentsystem.jpa.service.impl.*;
import lombok.Value;

import javax.persistence.EntityManager;

public class ApplicationContex {
    private static final EntityManager entityManager;
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final BankCardRepository bankCardRepository;
    private static final BankCardService bankCardService;
    private static final InstallmentRepository installmentRepository;
    private static final InstallmentService installmentService;
    private static final LoanRepository loanRepository;
    private static final LoanService loanService;
    private static final SemesterRepository semesterRepository;
    private static final SemesterService semesterService;
    private static final UniversityRepository universityRepository;
    private static final UniversityService universityService;
    private static final MarriedRepository marriedRepository;
    private static final MarriedService marriedService;

    static {
        entityManager =EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
        studentRepository = new StudentRepositoryImpl(entityManager);
        studentService = new StudentServiceImpl(studentRepository);
        bankCardRepository =new BankCardRepositoryImpl(entityManager);
        bankCardService =new BankCardServiceImpl(bankCardRepository);
        installmentRepository = new InstallmentRepositoryImpl(entityManager);
        installmentService = new InstallmentServiceImpl(installmentRepository);
        loanRepository = new LoanRepositoryImpl(entityManager);
        loanService = new LoanServiceImpl(loanRepository);
        semesterRepository = new SemesterRepositoryImpl(entityManager);
        semesterService = new SemesterServiceImpl(semesterRepository);
        universityRepository = new UniversityRepositoryImpl(entityManager);
        universityService = new UniversityServiceImpl(universityRepository);
        marriedRepository = new MarriedRepositoryImpl(entityManager);
        marriedService = new MarriedServiceImpl(marriedRepository);
    }

    public static SemesterService getSemesterServiceImpl(){
        return semesterService;
    }
    public static StudentService getStudentServiceImpl(){
        return studentService;
    }
    public static BankCardService getBankCardServiceImpl(){
        return bankCardService;
    }
    public static UniversityService getUniversityServiceImpl(){
        return universityService;
    }
    public static InstallmentService getInstallmentServiceImpl(){
        return installmentService;
    }
    public static LoanService getLoanServiceImpl(){
        return loanService;
    }
    public static MarriedService getMarriedServiceImpl(){return marriedService;}


}
