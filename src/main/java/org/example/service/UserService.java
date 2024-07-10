package org.example.service;

import org.example.model.Car;
import org.example.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUser();
    void clearUserTable();
    public List<User> getUserTheCar(Car car);

    List<User> getUserTheCar(int i, String model);
}
