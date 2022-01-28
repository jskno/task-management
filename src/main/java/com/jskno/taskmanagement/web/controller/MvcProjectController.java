package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.service.ProjectService;
import com.jskno.taskmanagement.web.converters.ProjectConverter;
import com.jskno.taskmanagement.web.dto.ProjectDto;
import com.jskno.taskmanagement.web.dto.TaskDto;
import com.jskno.taskmanagement.web.dto.TaskListDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/mvc-projects")
public class MvcProjectController {

    private ProjectService projectService;

    private ProjectConverter projectConverter;

    public MvcProjectController(ProjectService projectService, ProjectConverter projectConverter) {
        this.projectService = projectService;
        this.projectConverter = projectConverter;
    }

    @GetMapping
    public String getProjects(Model model) {
        List<Project> projects = projectService.findAll();
        List<ProjectDto> projectDtos = projectConverter.convertToDto(projects);

        model.addAttribute("projects", projectDtos);

        return "projects";
    }

    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("project", new ProjectDto());

        return "new-project";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id).get();
        model.addAttribute("project", projectConverter.convertToDto(project));

        return "project";
    }

    @PostMapping
    public String addProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new-project";
        }
        projectService.save(projectConverter.convertToEntity(projectDto));

        return "redirect:/mvc-projects";
    }

    @GetMapping("/{id}/add-tasks")
    public String getProjectEditPage(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id).orElse(new Project());
        model.addAttribute("project", project);
        TaskListDto tasksForm = new TaskListDto();
        for (int i = 1; i <= 3; i++) {
            tasksForm.addTask(new TaskDto());
        }
        model.addAttribute("tasksForm", tasksForm);
        return "add-tasks";
    }

    @PostMapping("{id}/save-tasks")
    public String saveTasks(@ModelAttribute TaskListDto tasksForm, @PathVariable Long id, Model model) {
        Project project = projectService.findById(id).orElse(new Project());
        projectService.addTasks(project, tasksForm.getTasks()
                .stream()
                .map(t -> projectConverter.convertTaskToEntity(t))
                .collect(Collectors.toList()));
        model.addAttribute("project", project);

        return "redirect:/mvc-projects/" + project.getId();
    }

    @RequestMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
        return "redirect:/mvc-projects";
    }
}
