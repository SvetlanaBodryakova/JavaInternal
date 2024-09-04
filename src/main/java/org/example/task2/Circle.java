package org.example.task2;

public class Circle extends Shape implements IShapes{

    private double radius;

    public Circle(String hatchColor, String borderColor, double radius) {
        super(hatchColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String getHatchColor() {
        return hatchColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}