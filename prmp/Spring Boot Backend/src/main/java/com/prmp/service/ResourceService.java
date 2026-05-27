package com.prmp.service;

import java.util.List;

import com.prmp.entity.Resource;

public interface ResourceService {

    Resource createResource(Resource resource);

    List<Resource> getAllResources();

    Resource updateResource(Integer id, Resource resource);
}