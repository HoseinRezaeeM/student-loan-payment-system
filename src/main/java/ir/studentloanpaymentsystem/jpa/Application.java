package ir.studentloanpaymentsystem.jpa;


import ir.studentloanpaymentsystem.jpa.menu.BaseMenu;
import ir.studentloanpaymentsystem.jpa.util.DatabaseToExcel;
import ir.studentloanpaymentsystem.jpa.util.ExcelToDatabase;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
       //  BaseMenu.fistMenu();

        //  DatabaseToExcel.writeStudentDataBaseToExcel();
          ExcelToDatabase.exceltoDataBaseStudent();

    }
}
