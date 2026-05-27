package com.prmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}