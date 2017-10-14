package com.sanzhar.twitter.service;

import com.sanzhar.twitter.model.User;
import com.sanzhar.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Transactional
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Transactional
    public List<User> getAllUsers(){

        return userRepository.getAllUsers();
    }

    @Transactional
    public void addUser(User user) {
        user.setActive(1);
        userRepository.addUser(user);
    }
}
