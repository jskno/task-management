package com.jskno.taskmanagement.service;

import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.model.Task;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll();

    Optional<Project> findById(Long id);

    Project save(Project project);

    void createProjectWithTasks() throws TaskNotSavedException;

    Project addTasks(Project project, List<Task> tasks);

    Iterable<Project> findAllIterable();

    void delete(Long id);

    Iterable<Project> findByName(String name);

    void throwsAnException();
}
