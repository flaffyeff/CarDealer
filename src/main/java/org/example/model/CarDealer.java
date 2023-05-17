package org.example.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarDealer {
    private List<Car> cars;
    private List<Customer> customers;

    // Конструктор
    public CarDealer() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public CarDealer(CarDealer other) {
        cars = new ArrayList<>();

        for (Car car : other.cars) {
            this.cars.add(new Car(car.getBrand(), car.getModel(), car.getYear(), car.getPrice()) {
                @Override
                public void printInfo() {
                    System.out.println("Brand: " +getBrand());
                    System.out.println("Model: " +getModel());
                    System.out.println("Year: " +getYear());
                    System.out.println("Price: " +getPrice());
                }
            });
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    // Метод для добавления автомобиля в автосалон
    public void addCar(Car car) {
        cars.add(car);
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void printCustomers() {
        System.out.println("Список клиентов:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
    public int getTotalValue() {
        int total = 0;
        for (Car car : cars) {
            total += car.getPrice();
        }
        return total;
    }
    public Car getMostExpensiveCar() {
        if (cars.isEmpty()) {
            return null;
        }

        Car mostExpensive = cars.get(0);
        for (Car car : cars) {
            if (car.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = car;
            }
        }

        return mostExpensive;
    }

    public Car getCheapestCar() {
        if (cars.isEmpty()) {
            return null;
        }

        Car cheapest = cars.get(0);
        for (Car car : cars) {
            if (car.getPrice() < cheapest.getPrice()) {
                cheapest = car;
            }
        }

        return cheapest;
    }

    // Метод для вывода информации обо всех автомобилях в автосалоне
    public void printAllCars() {
        if (cars.size() == 0)
            System.out.println("Автомобилей нет в наличии");
        for (Car car : cars) {
            car.printInfo();
            System.out.println();
        }
    }

    public void sortByModel(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getModel));
        System.out.println(cars);
    }

    public void sortByPrice(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getPrice));
        System.out.println(cars);
    }

    public void sortByYear(List<Car> cars) {
        cars.sort(Comparator.comparing(Car::getYear));
        System.out.println(cars);
    }
}
