package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Метод 1:");
        System.out.println(checkSum(5, 10));
        System.out.println();

        System.out.println("Метод 2:");
        System.out.println(isPositive(5));
        System.out.println();

        System.out.println("Метод 3:");
        System.out.println(isNegative(-5));
        System.out.println();

        System.out.println("Метод 4:");
        print(3, "Привет!");
        System.out.println();

        System.out.println("Метод 5:");
        System.out.println(isYearLeap(2004));
        System.out.println();

        System.out.println("Метод 6:");
        replaceElements();
        System.out.println();

        System.out.println("Метод 7:");
        createArray();
        System.out.println();

        System.out.println("Метод 8:");
        modifyArray();
        System.out.println();

        System.out.println("Метод 9:");
        makeArray(5);
        System.out.println();

        System.out.println("Метод 10:");
        System.out.println(Arrays.toString(createNewArray(5, 10)));

    }

    /*
    1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    private static boolean checkSum(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    /*
    2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    private static boolean isPositive(int a) {
        return a >= 0;
    }

    /*
    3. Написать метод, которому в качестве параметра передается целое число.
     Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    private static boolean isNegative(int a) {
        return a < 0;
    }

    /*
    4.Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    в консоль указанную строку, указанное количество раз;
     */
    private static void print(int a, String b) {
        for (int i = 1; i <= a; i++) {
            System.out.println(b);
        }
    }

    /*
    5. Написать метод, который определяет, является ли год високосным, и возвращает boolean
    (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
     при этом каждый 400-й – високосный.
     */
    private static boolean isYearLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /*
    6.Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static void replaceElements() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                array[i] = 0;
            else if (array[i] == 0)
                array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
     7.Задать пустой целочисленный массив длиной 100.
     С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    private static void createArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    8. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;
     */
    private static void modifyArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
     9. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
     если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
     индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
      */
    private static void makeArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j == size - 1 - i) {
                    array[i][j] = 1;
                }
            }
        }
        for (int[] a : array)
            System.out.println(Arrays.toString(a));
    }

    /*
    10. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
     типа int длиной len, каждая ячейка которого равна initialValue.
     */
    private static int[] createNewArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}