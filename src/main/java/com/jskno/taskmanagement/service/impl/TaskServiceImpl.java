package com.jskno.taskmanagement.service.impl;

import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Task;
import com.jskno.taskmanagement.persistence.repository.TaskRepository;
import com.jskno.taskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) throws TaskNotSavedException {
        return taskRepository.save(task);
//        throw new RuntimeException("Unable to save task");
//        throw new TaskNotSavedException("Unable to save task");
    }

}
