package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarDealerTest {

    private CarDealer carDealer;

    @BeforeEach
    public void setUp() {
        carDealer = new CarDealer();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("Toyota", "Camry", 2022, 30000);
        carDealer.addCar(car);

        List<Car> cars = carDealer.getCars();
        assertNotNull(cars);
        assertEquals(1, cars.size());
        assertEquals(car, cars.get(0));
    }

    @Test
    public void testGetMostExpensiveCar() {
        Car car1 = new Car("Toyota", "Camry", 2022, 30000);
        Car car2 = new Car("Honda", "Accord", 2022, 35000);
        Car car3 = new Car("Ford", "Mustang", 2022, 50000);

        carDealer.addCar(car1);
        carDealer.addCar(car2);
        carDealer.addCar(car3);

        Car mostExpensiveCar = carDealer.getMostExpensiveCar();
        assertNotNull(mostExpensiveCar);
        assertEquals(car3, mostExpensiveCar);
    }

    @Test
    public void testGetCheapestCar() {
        Car car1 = new Car("Toyota", "Camry", 2022, 30000);
        Car car2 = new Car("Honda", "Accord", 2022, 35000);
        Car car3 = new Car("Ford", "Mustang", 2022, 50000);

        carDealer.addCar(car1);
        carDealer.addCar(car2);
        carDealer.addCar(car3);

        Car cheapestCar = carDealer.getCheapestCar();
        assertNotNull(cheapestCar);
        assertEquals(car1, cheapestCar);
    }

    @Test
    public void testGetCarsWhenEmpty() {
        List<Car> cars = carDealer.getCars();
        assertNotNull(cars);
        assertEquals(0, cars.size());
    }

    @Test
    public void testGetMostExpensiveCarWhenEmpty() {
        Car mostExpensiveCar = carDealer.getMostExpensiveCar();
        assertNull(mostExpensiveCar);
    }

    @Test
    public void testGetCheapestCarWhenEmpty() {
        Car cheapestCar = carDealer.getCheapestCar();
        assertNull(cheapestCar);
    }
}