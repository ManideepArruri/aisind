package com.prmp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}