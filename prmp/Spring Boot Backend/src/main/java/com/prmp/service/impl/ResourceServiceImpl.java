package com.prmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prmp.entity.Resource;
import com.prmp.repository.ResourceRepository;
import com.prmp.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource createResource(
            Resource resource) {

        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {

        return resourceRepository.findAll();
    }

    @Override
    public Resource updateResource(Integer id,Resource updatedResource) {

        Resource resource = resourceRepository.findById(id)
        		.orElseThrow(() ->new RuntimeException("Resource not found"));

        resource.setUser(updatedResource.getUser());

        resource.setProject(updatedResource.getProject());

        resource.setUtilizationPct(updatedResource.getUtilizationPct());

        resource.setAvailability(updatedResource.getAvailability());

        return resourceRepository.save(resource);
    }
}