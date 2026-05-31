package com.prmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prmp.dto.ResourceRequestDTO;
import com.prmp.dto.ResourceResponseDTO;
import com.prmp.entity.Resource;
import com.prmp.service.ResourceService;

@RestController
@RequestMapping("/api/resources")

public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<ResourceResponseDTO> getAllResources() {

        return resourceService.getAllResources();
    }

    @PostMapping
    public ResourceResponseDTO createResource(@RequestBody ResourceRequestDTO resource) {
    	
        return resourceService.createResource(resource);
    }

    @PutMapping("/{id}")
    public ResourceResponseDTO updateResource(@PathVariable Long id,@RequestBody ResourceRequestDTO resource) {

        return resourceService.updateResource(id,resource);
    }
}