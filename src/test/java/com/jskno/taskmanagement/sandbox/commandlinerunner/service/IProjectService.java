package com.jskno.taskmanagement.sandbox.commandlinerunner.service;

import com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
