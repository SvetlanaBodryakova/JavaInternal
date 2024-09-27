package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void countEvenNumbers(int size) {
        int[] numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(50);
        }
        System.out.println("Набор чисел: " + Arrays.toString(numbers));

        long count = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Количество четных чисел: " + count);
    }

    public static void getCollectionInfo(List<String> words) {
        long count = words.stream()
                .filter(word -> word.equals("High"))
                .count();
        System.out.println("Строка High встречается в коллекции: " + count + " раз");

        String firstWord = words.stream()
                .findFirst()
                .orElse("0");
        System.out.println("Первый элемент коллекции: " + firstWord);

        String lastWord = words.stream()
                .reduce((word1, word2) -> word2)
                .orElse("0");
        System.out.println("Последний элемент коллекции: " + lastWord);
    }

    public static void collectionToSortedArray(List<String> collection) {
        String[] array = collection.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }

    public static void displayLogins() {
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины (пустая строка для завершения):");

        while (true) {
            String login = scanner.nextLine().trim();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        System.out.println("Логины, начинающиеся на букву 'f':");
        logins.stream()
                .filter(login -> login.charAt(0) == 'f')
                .distinct()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        System.out.println("Задание 1:");
        countEvenNumbers(10);
        System.out.println();

        System.out.println("Задание 2:");
        List<String> words = Arrays.asList("Highload", "High", "Load", "Highload");
        getCollectionInfo(words);
        System.out.println();

        System.out.println("Задание 3:");
        List<String> collection = Arrays.asList("f4", "f15", "f2", "f4", "f10");
        collectionToSortedArray(collection);
        System.out.println();

        System.out.println("Задание 4:");
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        //4.1. Необходимо узнать средний возраст студентов мужского пола;
        double averageAge = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.printf("Средний возраст студентов мужского пола: %.2f\n", averageAge);

        //4.2. Кому из студентов грозит получение повестки в этом году при условии, что призывной возраст установлен в диапазоне от 18 до 27 лет;

        List<Student> conscripts = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());
        System.out.println("Получение повестки грозит студентам: " + conscripts);
        System.out.println();

        System.out.println("Задание 5:");
        displayLogins();
    }
}