package com.prmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.entity.Sprint;
import com.prmp.repository.SprintRepository;
import com.prmp.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public Sprint createSprint(Sprint sprint) {

        return sprintRepository.save(sprint);
    }

    @Override
    public List<Sprint> getAllSprints() {

        return sprintRepository.findAll();
    }

    @Override
    public Sprint getSprintById(Integer id) {

        return sprintRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Sprint not found"));
    }

    @Override
    public Sprint updateSprint(Integer id,Sprint updatedSprint) {

        Sprint sprint = getSprintById(id);

        sprint.setSprintName(updatedSprint.getSprintName());

        sprint.setStartDate(updatedSprint.getStartDate());

        sprint.setEndDate(updatedSprint.getEndDate());

        sprint.setStatus(updatedSprint.getStatus());

        sprint.setProject(updatedSprint.getProject());

        return sprintRepository.save(sprint);
    }

    @Override
    public void deleteSprint(Integer id) {

        sprintRepository.deleteById(id);
    }
}