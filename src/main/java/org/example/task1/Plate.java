package org.example.task1;

public class Plate {
    private int foodAmount;

    public Plate(int foodAmount) {
        if (foodAmount > 0) {
            this.foodAmount = foodAmount;
        }
        else
            System.out.println("Введите положительное число. Количество еды в тарелке не может быть отрицательным");
    }

    protected void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В тарелку добавлено " + amount + " еды.");
        }
        else
            System.out.println("Введите положительное число. В тарелку не может быть добавлено отрицательное количество еды");
    }

    protected void reducingFood(int amount) {
        if (amount < 0) {
            System.out.println("Введите положительное число. Величина порции не может быть отрицательной");
        }
        else if (amount > foodAmount) {
            System.out.println("В тарелке недостаточно еды");
        }
        else {
            foodAmount -= amount;
        }
    }

    protected int getFoodAmount() {
        return foodAmount;
    }
}