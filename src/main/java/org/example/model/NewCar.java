package org.example.model;

public class NewCar extends Car{
    private int warranty;

    public NewCar(String model, String brand, int year, int price, int warranty) {
        super(model, brand, year, price);
        this.warranty = warranty;
    }

    @Override
    public void printInfo() {
        System.out.println("Brand: " +getBrand());
        System.out.println("Model: " +getModel());
        System.out.println("Year: " +getYear());
        System.out.println("Price: " +getPrice());
        System.out.println("Warranty: " +warranty);
    }
}
