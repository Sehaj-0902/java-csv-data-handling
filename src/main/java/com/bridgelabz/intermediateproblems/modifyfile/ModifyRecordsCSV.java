package com.bridgelabz.intermediateproblems.modifyfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModifyRecordsCSV {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\modifyfile\\employee_salary.csv";
        String outputFilePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediateproblems\\modifyfile\\updated_employee_salary.csv";
        String department = "IT";

        List<String[]> updatedRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            List<String[]> employeeRecords = reader.readAll();

            if (!employeeRecords.isEmpty()) {
                updatedRecords.add(employeeRecords.get(0));

                System.out.println("Employees with updated salary");
                for (int i = 1; i < employeeRecords.size(); i++) {
                    String[] record = employeeRecords.get(i);

                    if (record[2].trim().equalsIgnoreCase(department)) {
                        double currentSalary = Double.parseDouble(record[3].trim());
                        double updatedSalary = currentSalary * (1.1);
                        record[3] = String.format("%.1f", updatedSalary);

                        System.out.println("------------------------------");
                        System.out.println("ID: " + record[0] + "\nName: " + record[1] + "\nDepartment: " + record[2] + "\nOriginal Salary: " + currentSalary + "\nUpdated Salary: " + record[3]);
                    }
                    updatedRecords.add(record);
                }
                try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
                    writer.writeAll(updatedRecords);
                    System.out.println("\nSuccessfully updated salaries of employees of IT department!");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}