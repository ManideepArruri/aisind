package com.prmp.service;

import java.util.List;

import com.prmp.entity.Sprint;

public interface SprintService {

    Sprint createSprint(Sprint sprint);

    List<Sprint> getAllSprints();

    Sprint getSprintById(Integer id);

    Sprint updateSprint(Integer id,Sprint sprint);

    void deleteSprint(Integer id);
}