package com.prmp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prmp.entity.Prediction;

public interface PredictionRepository
        extends JpaRepository<Prediction, Long> {

    List<Prediction> findByProject_ProjectId(Long projectId);
}