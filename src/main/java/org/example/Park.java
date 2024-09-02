package org.example;

public class Park {
    private Attraction[] attractions;
    private String parkName;

    public Park(String parkName, int attractionNumber) {
        this.parkName = parkName;
        this.attractions = new Attraction[attractionNumber];
    }

    public void addAttraction(int id, String name, String workingHours, double price) {
        if (id >= 0 && id < attractions.length) {
            attractions[id] = new Attraction(name, workingHours, price);
        } else {
            System.out.println("Неверный id");
        }
    }

    public void getAttractionInfo() {
        System.out.println("Аттракционы парка " + parkName + ":");
        for (Attraction attr : attractions) {
            attr.getInfo();
        }
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void getInfo() {
            System.out.println(
                    "Аттракцион: " + name + "\n" +
                            "Время работы: " + workingHours + "\n" +
                            "Стоимость: " + price + "\n");
        }
    }
}