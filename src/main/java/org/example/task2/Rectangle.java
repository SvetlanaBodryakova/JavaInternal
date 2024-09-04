package org.example.task2;

public class Rectangle extends Shape implements IShapes {

    private double width;
    private double height;

    public Rectangle(String hatchColor, String borderColor, double width, double height) {
        super(hatchColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
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