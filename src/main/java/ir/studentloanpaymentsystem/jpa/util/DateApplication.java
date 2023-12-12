package ir.studentloanpaymentsystem.jpa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static ir.studentloanpaymentsystem.jpa.menu.BaseMenu.scanner;


public class DateApplication {
    public static final LocalDate DATEAPLICATION =LocalDate.of(1401, 7,8);

    public static LocalDate addDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date, dtf);
    }

}
