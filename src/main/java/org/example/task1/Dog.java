package org.example.task1;

public class Dog extends Animal {

    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    protected void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " не может пробежать больше 500 м");
        }
        else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    protected void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + " не может проплыть больше 10 м");
        }
        else {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }

    protected static int getDogCount() {
        return dogCount;
    }
}