package com.bridgelabz.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SearchRecordsCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\writefile\\employees.csv";
        String searchName = "sehaj";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> employeeRecords = reader.readAll();

            for (int i = 1; i < employeeRecords.size(); i++) {
                String[] record = employeeRecords.get(i);
                if (record[1].trim().equalsIgnoreCase(searchName.trim())) {
                    System.out.println("Department: " + record[2]);
                    System.out.println("Salary: " + record[3]);
                }
            }
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}