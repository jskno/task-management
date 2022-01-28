package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.service.ProjectService;
import com.jskno.taskmanagement.web.converters.ProjectConverter;
import com.jskno.taskmanagement.web.dto.ProjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@Validated
public class ProjectController {

    private ProjectService projectService;

    private ProjectConverter projectConverter;

    public ProjectController(ProjectService projectService, ProjectConverter projectConverter) {
        this.projectService = projectService;
        this.projectConverter = projectConverter;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project entity =  projectService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found"));
        return projectConverter.convertToDto(entity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto create(@RequestBody @Valid ProjectDto project) {
        return projectConverter.convertToDto(
                projectService.save(projectConverter.convertToEntity(project)));
    }

    @GetMapping
    public List<ProjectDto> findAll() {
        return projectConverter.convertToDto(projectService.findAll());
    }

    @GetMapping(value = "/byName")
    public Collection<ProjectDto> findProjects(@RequestParam(name = "name", defaultValue = "") String name) {
        Iterable<Project> allProjects = this.projectService.findByName(name);
        List<ProjectDto> projectDtos = projectConverter.convertToDto(allProjects);
        return projectDtos;
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto updatedProject) {
        Project projectEntity = projectConverter.convertToEntity(updatedProject);
        return projectConverter.convertToDto(this.projectService.save(projectEntity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }

    @GetMapping("/aop")
    public void throwsAnException() {
        projectService.throwsAnException();
    }
}
