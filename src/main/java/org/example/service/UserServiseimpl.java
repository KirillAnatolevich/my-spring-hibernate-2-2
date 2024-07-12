package org.example.service;


import org.example.dao.UserDao;
import org.example.model.Car;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiseimpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    // readOnly - только для чтения, или нет
    @Transactional(readOnly = true)
    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }
    @Transactional
    @Override
    public void clearUserTable(){
        userDao.clearUserTable();
    }
    @Transactional
    @Override
    public List<User> getUserTheCar(int series, String model){
        return userDao.getUserTheCar(series, model);
    }

}
