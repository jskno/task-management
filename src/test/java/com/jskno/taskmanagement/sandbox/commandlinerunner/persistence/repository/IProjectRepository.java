package com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.repository;

import com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.model.Project;

import java.util.Optional;

public interface IProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
