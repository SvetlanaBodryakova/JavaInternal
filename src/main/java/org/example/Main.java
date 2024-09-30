package org.example;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());
        orangeBox2.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами: " + orangeBox2.getWeight());

        System.out.println("Вес коробки с яблоками равен весу первой коробки апельсинов: " + appleBox.compare(orangeBox1));
        System.out.println("Вес коробки с яблоками равен весу второй коробки апельсинов: " + appleBox.compare(orangeBox2));
        System.out.println("Вес первой коробки апельсинов равен весу второй: " + orangeBox1.compare(orangeBox2));

        // Пересыпаем апельсины из первой коробки во вторую
        orangeBox1.moveFruits(orangeBox2);


        System.out.println("Вес первой коробки с апельсинами после пересыпки: " + orangeBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами после пересыпки: " + orangeBox2.getWeight());
    }
}