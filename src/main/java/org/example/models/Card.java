package org.example.models;

public class Card {

    private String name;
    private double price;

    public Card(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Card o = (Card) obj;
        return this.getName() == o.getName() && this.getPrice() == o.getPrice();
    }

    @Override
    public String toString() {
        return "product name: " + name + "\n" + "price: " + price;
    }

}
