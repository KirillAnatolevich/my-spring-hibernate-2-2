package org.example;


import org.example.config.AppConfig;
import org.example.model.Car;
import org.example.model.User;
import org.example.service.CarService;
import org.example.service.UserService;
import org.example.service.UserServiseimpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            System.setErr(new PrintStream(new FileOutputStream("lib/errorAddDialect.txt", false), true));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        carService.clearCarTable();

        carService.add(new Car(10, "Победа"));
        carService.add(new Car(20, "Москвич"));
        carService.add(new Car(30, "Волга"));
        carService.add(new Car(40, "Чайка"));

        List<Car> cars = carService.listCar();
        for (Car item: cars){
            System.out.println("Series = " + item.getSeries());
            System.out.println("Model = " + item.getModel());
            System.out.println();
        }

        System.out.println("________________________");

        userService.clearUserTable();

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setCar(carService.listCar().get(0));
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setCar(carService.listCar().get(1));
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setCar(carService.listCar().get(2));
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setCar(carService.listCar().get(3));

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);




        List<User> users = userService.listUser();

        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+ user.getFirstName());
            System.out.println("Last Name = "+ user.getLastName());
            System.out.println("Email = "+ user.getEmail());

            System.out.println();
        }

        System.out.println("________________________");

        System.out.println("________________________");

        for (User item: userService.getUserTheCar(30, "Волга")){
            System.out.println("Id = "+item.getId());
            System.out.println("First Name = "+ item.getFirstName());
            System.out.println("Last Name = "+ item.getLastName());
            System.out.println("Email = "+ item.getEmail());
        }
    }
}