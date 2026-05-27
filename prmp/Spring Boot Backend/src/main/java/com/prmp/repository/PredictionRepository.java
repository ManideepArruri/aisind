package com.prmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Prediction;

public interface PredictionRepository extends JpaRepository<Prediction,Integer> {

}
