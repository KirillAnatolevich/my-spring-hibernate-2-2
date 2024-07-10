package org.example.service;

import org.example.model.Car;
import org.example.model.User;

import java.util.List;

public interface CarService {
    void add(Car car);
    List<Car> listCar();
    void clearCarTable();
}
