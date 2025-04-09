package com.bridgelabz.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SortRecordsCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\writefile\\employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> employees = reader.readAll();

            // Removing header
            if (!employees.isEmpty()) {
                employees.remove(0);
            }

            // Sorting employees based on salary
            employees.sort((emp1, emp2) -> {
                int emp1Salary = Integer.parseInt(emp1[3]);
                int emp2Salary = Integer.parseInt(emp2[3]);
                return Integer.compare(emp2Salary, emp1Salary);
            });

            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < 5; i++) {
                String[] sortedEmployees = employees.get(i);
                System.out.println("------------------------------");
                System.out.println("ID: " + sortedEmployees[0].trim() + "\nName: " + sortedEmployees[1].trim() + "\nDepartment: " + sortedEmployees[2].trim() + "\nSalary: " + sortedEmployees[3].trim());
            }
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
