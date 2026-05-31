package com.prmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}