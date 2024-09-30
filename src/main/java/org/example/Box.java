package org.example;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void moveFruits(Box<T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Неверно указана коробка для пересыпки");
            return;
        }
        anotherBox.fruits.addAll(this.fruits);
        fruits.clear();
    }
}