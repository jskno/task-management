package com.jskno.taskmanagement.web.converters;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.model.Task;
import com.jskno.taskmanagement.web.dto.ProjectDto;
import com.jskno.taskmanagement.web.dto.TaskDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ProjectConverter {

    public ProjectDto convertToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated());
        dto.setTasks(entity.getTasks()
                .stream()
                .map(t -> convertTaskToDto(t))
                .collect(Collectors.toSet()));

        return dto;
    }

    public Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getDateCreated());
        if (!StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return project;
    }

    public TaskDto convertTaskToDto(Task entity) {
        TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getDateCreated(), entity.getDueDate(), entity.getStatus());
        return dto;
    }

    public Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.getName(), dto.getDescription(), dto.getDateCreated(), dto.getDueDate(), dto.getStatus());
        if (!StringUtils.isEmpty(dto.getId())) {
            task.setId(dto.getId());
        }
        return task;
    }

    public List<ProjectDto> convertToDto(List<Project> entities) {
        return entities.stream()
                    .map(project -> convertToDto(project))
                    .collect(Collectors.toList());
    }

    public List<ProjectDto> convertToDto(Iterable<Project> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(project -> convertToDto(project))
                .collect(Collectors.toList());
    }
}
