package org.example.task1;

public class Animal {

    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    protected void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    protected void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    protected static int getAnimalCount() {
        return animalCount;
    }
}
