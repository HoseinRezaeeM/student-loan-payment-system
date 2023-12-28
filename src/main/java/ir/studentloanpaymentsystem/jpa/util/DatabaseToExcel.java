package ir.studentloanpaymentsystem.jpa.util;

import ir.studentloanpaymentsystem.jpa.domin.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;


public class DatabaseToExcel {

      public static void writeStudentDataBaseToExcel() throws IOException {

            Collection<Student> studentCollection = ApplicationContex.getStudentServiceImpl().findAll();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Data");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("ID");
            row.createCell(1).setCellValue("Firstname");
            row.createCell(2).setCellValue("Lastname");
            row.createCell(3).setCellValue("Fathername");
            row.createCell(4).setCellValue("Mothername");
            row.createCell(5).setCellValue("NationalCode");
            row.createCell(6).setCellValue("Username");
            row.createCell(7).setCellValue("Password");

            int rowNum = 1;

            for (Student data : studentCollection) {
                  row = sheet.createRow(rowNum++);
                  row.createCell(0).setCellValue(data.getId());
                  row.createCell(1).setCellValue(data.getFirstname());
                  row.createCell(2).setCellValue(data.getLastname());
                  row.createCell(3).setCellValue(data.getFathername());
                  row.createCell(4).setCellValue(data.getMothername());
                  row.createCell(5).setCellValue(data.getNationalCode());
                  row.createCell(6).setCellValue(data.getUsername());
                  row.createCell(7).setCellValue(data.getPassword());
            }
            for (int i = 0; i < 7; i++) {
                  sheet.autoSizeColumn(0);
                  sheet.autoSizeColumn(1);
                  sheet.autoSizeColumn(2);
                  sheet.autoSizeColumn(3);
                  sheet.autoSizeColumn(4);
                  sheet.autoSizeColumn(5);
                  sheet.autoSizeColumn(6);
                  sheet.autoSizeColumn(7);


            }
            try (FileOutputStream outputStream = new FileOutputStream("dataStudent.xlsx")) {
                  workbook.write(outputStream);
                  System.out.println("Excel file has been generated successfully!");
            }

      }
}