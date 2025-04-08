package com.bridgelabz.basicproblems.writefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DELL\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basicproblems\\writefile\\employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Sehaj,Engineering,70000\n");
            writer.write("102,Daisy,HR,60000\n");
            writer.write("103,Alex,Sales,55000\n");
            writer.write("104,Sam,Finance,65000\n");
            writer.write("105,Olivia,Marketing,50000\n");

            System.out.println("Writing data to CSV file done!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}