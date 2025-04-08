package com.bridgelabz.intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\readfile\\students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            System.out.println("Students having more than 80 marks");
            while((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3].trim());
                if (marks > 80) {
                    System.out.println("-----------------------------------");
                    System.out.println("ID: " + columns[0].trim() + "\nName: " + columns[1].trim() + "\nMarks: " + columns[3].trim());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}