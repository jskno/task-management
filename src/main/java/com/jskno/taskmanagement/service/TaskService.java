package com.jskno.taskmanagement.service;

import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Task;

import java.util.Optional;

public interface TaskService {

    Iterable<Task> findAll();

    Optional<Task> findById(Long id);

    Task save(Task task) throws TaskNotSavedException;
}
