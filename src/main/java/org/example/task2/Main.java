package org.example.task2;

public class Main {
    public static void main(String[] args) {

        IShapes triangle = new Triangle("красный", "белый", 3.0,4.0,5.0);
        IShapes rectangle = new Rectangle("синий","зеленый",10.0,20.0);
        IShapes circle = new Circle("желтый","черный",15.0);

        System.out.println("Треугольник:");
        triangle.getInfo();
        System.out.println("Прямоугольник");
        rectangle.getInfo();
        System.out.println("Круг");
        circle.getInfo();
    }
}
