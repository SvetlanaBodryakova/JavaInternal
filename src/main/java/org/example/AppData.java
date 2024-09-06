package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData {

    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            StringBuilder line = new StringBuilder();
            for (String s : header)
                line.append(s).append(";");
            line.append("\n");

            for (int[] d : data) {
                for (int num : d)
                    line.append(num).append(";");
                line.append("\n");
            }
            writer.write(line.toString());
            System.out.println("Данные сохранены в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upload(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String[] header = reader.readLine().split(";");

            List<Integer[]> list = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");
                Integer[] numbers = new Integer[row.length];
                for (int i = 0; i < row.length; i++) {
                    numbers[i] = Integer.parseInt(row[i]);
                }
                list.add(numbers);
            }
            System.out.println("Данные прочитаны из файла: " + fileName);
            System.out.println(Arrays.toString(header));
            for (Integer[] n : list) {
                System.out.println(Arrays.toString(n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}