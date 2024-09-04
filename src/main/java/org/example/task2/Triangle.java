package org.example.task2;

public class Triangle extends Shape implements IShapes{

    private double side1;
    private double side2;
    private double side3;

    public Triangle(String hatchColor, String borderColor, double side1, double side2, double side3) {
        super(hatchColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double p = (side1 + side2 + side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public double perimeter() {
        return side1+side2+side3;
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
