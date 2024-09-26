package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void countUniqueWords(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : array) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Set<String> uniqueWords = map.keySet();
        System.out.println("Уникальные слова: " + uniqueWords);

        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            System.out.println(mp.getKey() + " повторяется " + mp.getValue() + " раз");
        }
    }

    public static void main(String[] args) {

        System.out.println("Задание 1");
        String[] colors = new String[]
                {"синий", "зеленый", "красный", "белый", "желтый", "оранжевый", "черный",
                        "голубой", "фиолетовый", "красный", "синий", "черный", "красный"};

        countUniqueWords(colors);

        System.out.println("Задание 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+375295555555");
        phoneBook.add("Петров", "+375296666666");
        phoneBook.add("Сидоров", "+375297777777");
        phoneBook.add("Иванов", "+375298888888");

        System.out.println(phoneBook.get("Иванов"));
    }
}