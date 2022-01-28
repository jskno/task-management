package com.jskno.taskmanagement.service;

import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Project;

import java.util.Optional;

public interface NoDDBBProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
