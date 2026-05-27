package com.prmp.service;

import java.util.List;

import com.prmp.entity.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
}