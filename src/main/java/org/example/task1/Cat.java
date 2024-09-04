package org.example.task1;

public class Cat extends Animal {

    private static int catCount = 0;
    private boolean fullness;

    public Cat(String name) {
        super(name);
        catCount++;
        fullness = false;
    }

    @Override
    protected void run(int distance) {
        if (distance > 200) {
            System.out.println(name + " не может пробежать больше 200 м");
        }
        else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    protected void swim(int distance) {
            System.out.println(name + " не умеет плавать");

    }

    protected static int getCatCount() {
        return catCount;
    }

    protected void eat(int portion, Plate plate) {
        if (portion > plate.getFoodAmount()) {
            System.out.println("Кот " + name + " не может поесть. В тарелке недостаточно еды");
        }
        else if (portion < 0) {
            System.out.println("Введите положительное число. Величина порции не может быть отрицательной");
        }
        else if (fullness) {
            System.out.println("Кот не голоден");
        }
        else {
            fullness = true;
            plate.reducingFood(portion);
            System.out.println("Кот " + name + " поел");
        }
    }

    protected void getFullness() {
        System.out.println((fullness) ? "Кот " + name + " сыт" : "Кот " + name + " голоден");
    }
}