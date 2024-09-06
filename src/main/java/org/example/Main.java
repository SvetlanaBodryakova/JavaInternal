package org.example;

public class Main {
    public static void main(String[] args) {

        String[] header = new String[]{"Value1", "Value2", "Value3"};
        int[][] data = new int[][]{{100, 200, 123}, {300, 400, 500}};

        AppData appData = new AppData(header,data);
        appData.save("data.csv");
        appData.upload("data.csv");
    }
}