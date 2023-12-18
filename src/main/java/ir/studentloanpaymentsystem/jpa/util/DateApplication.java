package ir.studentloanpaymentsystem.jpa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class DateApplication {
    public static final LocalDate DATENOWAPLICATION =LocalDate.of(1402, 11,27);

    public static LocalDate addDate(String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date, pattern);
    }

}
