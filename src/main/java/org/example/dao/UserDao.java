package org.example.dao;

import org.example.model.Car;
import org.example.model.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUser();
    void clearUserTable();
    public List<User> getUserTheCar(int series, String model);
}
