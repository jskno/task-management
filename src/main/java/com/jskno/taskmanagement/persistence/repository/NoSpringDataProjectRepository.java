package com.jskno.taskmanagement.persistence.repository;

import com.jskno.taskmanagement.persistence.model.Project;

import java.util.Optional;

public interface NoSpringDataProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
