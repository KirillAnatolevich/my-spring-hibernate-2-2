package org.example.dao;

import org.example.model.Car;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUser() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    @Override
    public void clearUserTable(){
//        try {
            sessionFactory.getCurrentSession().createQuery("delete from User").executeUpdate();
//        }catch (Exception e){
//            System.out.println("Не удалось очистить таблицу");
//        }
    }
    @Override
    public List<User> getUserTheCar(Car car){
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(String.format("from User where car_id = %d", car.getId()));
        return query.getResultList();

    }
    @Override
    public List<User> getUserTheCar(int series, String model){
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(String.format("select user from User as user, Car as car where user.car.series = %d and user.car.model = '%s'", series, model));
        return query.getResultList();

    }
}
