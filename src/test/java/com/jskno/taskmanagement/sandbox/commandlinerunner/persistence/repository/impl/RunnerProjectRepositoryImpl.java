package com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.repository.impl;

import com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.model.Project;
import com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunnerProjectRepositoryImpl implements IProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(RunnerProjectRepositoryImpl.class);

    private String prefix;
    private Integer suffix;

    List<Project> projects = new ArrayList<>();

    public RunnerProjectRepositoryImpl(
            @Value("${project.prefix}") String prefix,
            @Value("${project.suffix}") Integer suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);

        if(existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            projects.add(new Project(project));
        }

        return project;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }
}
