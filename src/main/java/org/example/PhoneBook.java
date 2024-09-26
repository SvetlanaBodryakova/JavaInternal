package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public void add(String lastName, String number) {
        phoneBook.put(number, lastName);
    }

    public List<String> get(String lastName) {
        List<String> phoneNumber = new ArrayList<>();

        for (Map.Entry<String, String> map : phoneBook.entrySet()) {
            if (lastName.equals(map.getValue())) {
                phoneNumber.add(map.getKey());
            }
        }
        return phoneNumber;
    }
}