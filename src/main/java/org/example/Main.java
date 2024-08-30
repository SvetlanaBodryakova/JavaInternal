package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Метод 1:");
        printThreeWords();
        System.out.println();

        System.out.println("Метод 2:");
        checkSumSign();
        System.out.println();

        System.out.println("Метод 3:");
        printColor();
        System.out.println();

        System.out.println("Метод 4:");
        compareNumbers();
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    private static void checkSumSign() {
        int a = -50;
        int b = 10;
        int sum = a + b;
        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    private static void printColor() {
        int value = 500;
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 100)
            System.out.println("Зеленый");
        else
            System.out.println("Желтый");
    }

    private static void compareNumbers() {
        int a = 500;
        int b = 100;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}