package org.example.task1;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Василий");
        Dog dog1 = new Dog("Джек");

        // Коты и собаки бегут и плывут
        cat1.run(100);
        cat1.swim(3);
        dog1.run(400);
        dog1.swim(5);
        System.out.println();

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Матроскин");
        cats[2] = new Cat("Сеня");

        Plate plate = new Plate(50);

        // Кормим котов из тарелки
        for (Cat cat : cats) {
            cat.eat(15, plate);
        }

        // Определяем сытость котов
        System.out.println("Сытость котов:");
        for (Cat cat : cats) {
            cat.getFullness();
        }

        // Определяем остаток еды в тарелке
        System.out.println("В тарелке осталось " + plate.getFoodAmount() + " еды");

        // Добавляем еду в тарелку
        plate.addFood(5);

        //Кормим кота
        Cat cat2 = new Cat("Черныш");
        cat2.eat(25, plate);
        System.out.println("В тарелке осталось " + plate.getFoodAmount() + " еды");

        // Подсчет созданных котов, собак, животных
        System.out.println();
        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
    }
}