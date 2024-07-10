package org.example.service;


import org.example.dao.CarDao;
import org.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceimpl implements CarService{
    @Autowired
    CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Car> listCar() {
        return carDao.listCar();
    }
    @Transactional
    @Override
    public void clearCarTable() {
        carDao.clearCarTable();
    }
}
