package org.example.model;

public class Car {
    private String model;
    private String brand;
    private int year;
    private int price;

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car(String model, String brand, int year, int price) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void printInfo() {

    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ") - $" + price;
    }
}
