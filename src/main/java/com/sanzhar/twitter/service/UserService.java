package com.sanzhar.twitter.service;


import com.sanzhar.twitter.model.User;

import java.util.List;

public interface UserService {

    public User getUserByLoginAndPassword(String login, String password);
    public User getUserByLogin(String login);
    public List<User> getAllUsers();
    public void addUser(User user);

}
