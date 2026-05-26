package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.entity.Sprint;
import com.prmp.service.SprintService;

@RestController
@RequestMapping("/api/sprints")

public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping
    public Sprint createSprint(@RequestBody Sprint sprint) {

        return sprintService.createSprint(sprint);
    }

    @GetMapping
    public List<Sprint> getAllSprints() {

        return sprintService.getAllSprints();
    }

    @GetMapping("/{id}")
    public Sprint getSprintById(@PathVariable Integer id) {

        return sprintService.getSprintById(id);
    }

    @PutMapping("/{id}")
    public Sprint updateSprint(@PathVariable Integer id,@RequestBody Sprint sprint) {

        return sprintService.updateSprint(id,sprint);
    }

    @DeleteMapping("/{id}")
    public String deleteSprint(@PathVariable Integer id) {

        sprintService.deleteSprint(id);

        return "Sprint deleted successfully";
    }
}