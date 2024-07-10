package org.example.dao;

import org.example.model.Car;
import org.example.model.User;

import java.util.List;

public interface CarDao {
    void add(Car car);
    List<Car> listCar();
    void clearCarTable();
}
