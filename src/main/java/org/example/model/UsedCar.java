package org.example.model;

public class UsedCar extends Car{
    private int mileage;

    public UsedCar(String model, String brand, int year, int price, int mileage) {
        super(model, brand, year, price);
        this.mileage = mileage;
    }

    @Override
    public void printInfo() {
        System.out.println("Brand: "+getBrand());
        System.out.println("Model: "+getModel());
        System.out.println("Year: "+getYear());
        System.out.println("Price: "+getPrice());
        System.out.println("Mileage: "+mileage);
    }
}
