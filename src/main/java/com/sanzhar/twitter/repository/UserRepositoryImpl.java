package com.sanzhar.twitter.repository;

import com.sanzhar.twitter.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User where login=:login and password=:pass")
                .setParameter("login", login)
                .setParameter("pass", password).list();
        User user = null;

        if(!users.isEmpty()){
            user = users.get(0);
        }

        return user;
    }

    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User where login=:login")
                .setParameter("login", login).list();
        User user = null;

        if(!users.isEmpty()){
            user = users.get(0);
        }

        return user;
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();

        return users;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

}
