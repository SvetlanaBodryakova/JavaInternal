package org.example;

public class Factorial {

    public static long countFactorial(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Факториал может быть вычислен только для неотрицательных чисел");
        else {
            long result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println(countFactorial(7));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}