package org.example;

import org.example.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarDealer dealer = new CarDealer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в Автосалон!");
        int choice;
        do {
            System.out.println("""
                    \nВыберите действие:
                    1)Добавить автомобиль в Автосалон
                    2)Вывести все автомобили, имеющиеся в салоне
                    3)Вывести самый дорогой автомобиль
                    4)Вывести самый дешевый автомобиль
                    5)Добавить клиента
                    6)Вывести всех клиентов Автосалона
                    7)Выйти""");
            choice = scanner.nextInt();
            switch (choice) {
                case (1) -> {
                    System.out.println("Введите название автомобиля: ");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    System.out.println("Введите модель автомобиля: ");
                    String model = scanner.nextLine();
                    System.out.println("Введите год выпуска автомобиля: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите стоимость автомобиля: ");
                    int price = scanner.nextInt();
                    System.out.println("""
                            Введите тип машины, которую хотите добавить: 
                            1) Добавить новый автомобиль
                            2) Добавить подержанный автомобиль
                            """);
                    choice = scanner.nextInt();
                    switch (choice) {
                        case (1) -> {
                            System.out.println("Введите гарантийный срок на автомобиль: ");
                            int warrantyPeriod = scanner.nextInt();
                            dealer.addCar(new NewCar(brand, model, year, price, warrantyPeriod));
                            System.out.println("Автомобиль добавлен!");
                        }
                        case (2) -> {
                            System.out.println("Введите пробег автомобиля: ");
                            int mileage = scanner.nextInt();
                            dealer.addCar(new UsedCar(brand, model, year, price, mileage));
                            System.out.println("Автомобиль добавлен!");
                        }
                    }

                }
                case (2) -> {
                    System.out.println("""
                            Отсортировать данные по:
                            1) Модели
                            2) Цене
                            3) Году
                            """);
                    choice = scanner.nextInt();
                    switch (choice) {
                        case (1) -> {
                            dealer.sortByModel(dealer.getCars());
                        }
                        case (2) -> {
                            dealer.sortByPrice(dealer.getCars());
                        }
                        case (3) -> {
                            dealer.sortByYear(dealer.getCars());
                        }
                    }
                    System.out.println("Общая стоимость автосалона: $" +dealer.getTotalValue());
                }
                case (3) -> {
                    Car mostExpensiveCar = dealer.getMostExpensiveCar();
                    if (mostExpensiveCar != null) {
                        System.out.println("Самый дорогой автомобиль: "+mostExpensiveCar.toString());
                    }
                }
                case (4) -> {
                    Car cheapestCar = dealer.getCheapestCar();
                    if (cheapestCar != null) {
                        System.out.println("Самый дешевый автомобиль: "+cheapestCar.toString());
                    }
                }
                case (5) -> {
                    System.out.println("Введите Имя и Фамилию клиента: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Введите адрес электронной почты клиента: ");
                    String email = scanner.nextLine();
                    System.out.println("Введите номер телефона клиента: ");
                    String phone = scanner.nextLine();
                    dealer.addCustomer(new Customer(name, email, phone));
                }
                case (6) -> {
                    dealer.printCustomers();
                }
                default -> {
                    if (choice > 7 || choice < 0)
                        System.out.println("Неверные данные");
                }
            }
        } while (choice != 7);
    }
}