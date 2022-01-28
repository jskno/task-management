package com.jskno.taskmanagement.web.dto;

import com.jskno.taskmanagement.web.dto.TaskDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProjectDto {

    private Long id;

    @NotBlank(message = "The project name must be informed")
    private String name;

    private LocalDate dateCreated;

    private Set<TaskDto> tasks;

    public ProjectDto() {
    }

    public ProjectDto(String name, LocalDate dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.tasks = new HashSet<>();
    }

    public ProjectDto(Long id, String name, LocalDate dateCreated) {
        this(name, dateCreated);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<TaskDto> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDto> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto that = (ProjectDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", tasks=" + tasks +
                '}';
    }
}
