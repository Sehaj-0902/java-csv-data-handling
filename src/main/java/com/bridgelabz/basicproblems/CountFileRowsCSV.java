package com.bridgelabz.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountFileRowsCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\readfile\\students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            int count = 0;
            while((line = br.readLine()) != null) {
                count++;
            }
            System.out.println("Number of records: " + count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}