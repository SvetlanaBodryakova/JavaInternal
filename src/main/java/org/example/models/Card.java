package org.example.models;

public class Card {

    private String productName;
    private double price;

    public Card(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Card o = (Card) obj;
        return this.getProductName() == o.getProductName() && this.getPrice() == o.getPrice();
    }
    @Override
    public String toString() {
        return "product name: " + productName + "\n" + "price: " + price;
    }

}
