package org.example;

public class Main {

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (String[] row : array) {
            if (array.length != 4 || row.length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4х4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат данных в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //Корректный массив
        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array1);
            System.out.println("Сумма элементов массива равна: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Массив с неверным размером
        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15"}
        };

        try {
            int result = sumArray(array2);
            System.out.println("Сумма элементов массива равна: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Массив с неверным типом данных
        String[][] array3 = {
                {"1", "2", "3", "string"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array3);
            System.out.println("Сумма элементов массива равна: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}