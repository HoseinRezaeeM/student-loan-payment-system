package ir.studentloanpaymentsystem.jpa.util;

import ir.studentloanpaymentsystem.jpa.domin.Student;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class ExcelToDatabase {

      public static void exceltoDataBaseStudent() {

            try {
                  FileInputStream file = new FileInputStream(new File("dataStudent.xlsx"));
                  XSSFWorkbook workbook =new XSSFWorkbook(file);
                  XSSFSheet sheet =workbook.getSheetAt(0);
                  for (Row row : sheet) {

                        String firstname = row.getCell(1).getStringCellValue();
                        Student student = new Student(firstname);
                        ApplicationContex.getStudentServiceImpl().save(student);
                        }

            } catch (IOException e) {
                  e.printStackTrace();
            }
      }
}

