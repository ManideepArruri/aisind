package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.entity.Resource;
import com.prmp.service.ResourceService;

@RestController
@RequestMapping("/api/resources")

public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getAllResources() {

        return resourceService.getAllResources();
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
    	
        return resourceService.createResource(resource);
    }

    @PutMapping("/{id}")
    public Resource updateResource(@PathVariable Integer id,@RequestBody Resource resource) {

        return resourceService.updateResource(id,resource);
    }
}