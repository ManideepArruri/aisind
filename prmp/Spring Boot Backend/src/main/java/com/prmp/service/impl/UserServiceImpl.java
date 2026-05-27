package com.prmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.entity.User;
import com.prmp.repository.UserRepository;
import com.prmp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {

        User user = getUserById(id);

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}