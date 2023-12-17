package applicationtest;

import ir.studentloanpaymentsystem.jpa.util.PasswordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordGeneratorTest {

    @Test
    void generatePassword() {
        System.out.println(PasswordGenerator.generatePassword());
        Assertions.assertNotNull(PasswordGenerator.generatePassword());
    }
}