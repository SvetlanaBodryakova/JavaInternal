package org.example.task2;

public interface IShapes {

    double area(); // расчет площади
    double perimeter(); // расчет периметра
    String getHatchColor(); // цвет заливки
    String getBorderColor(); // цвет границ
    default void getInfo() {
        System.out.println(
                "Периметр: " + perimeter() + "\n" +
                        "Площадь: " + area() + "\n" +
                        "Цвет заливки: " + getHatchColor() + "\n" +
                        "Цвет границы: " + getBorderColor() + "\n");
        System.out.println();
    }
}