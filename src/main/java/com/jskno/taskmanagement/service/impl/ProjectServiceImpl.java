package com.jskno.taskmanagement.service.impl;

import com.jskno.taskmanagement.event.ProjectCreatedEvent;
import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.model.Task;
import com.jskno.taskmanagement.persistence.repository.ProjectRepository;
import com.jskno.taskmanagement.persistence.repository.impl.NoDDBBProjectRepositoryImpl;
import com.jskno.taskmanagement.service.ProjectService;
import com.jskno.taskmanagement.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOG = LoggerFactory.getLogger(NoDDBBProjectRepositoryImpl.class);

    private ProjectRepository projectRepository;
    private TaskService taskService;

    private String additionalInfo;
    private String prefix;
    private Integer suffix;

    @Autowired
    public ProjectServiceImpl(
            ProjectRepository projectRepository,
            TaskService taskService,
            ApplicationEventPublisher applicationEventPublisher,
            @Value("${additional.serviceInfo}") String additionalInfo,
            @Value("${project.prefix}") String prefix,
            @Value("${project.suffix}") Integer suffix) {

        this.projectRepository = projectRepository;
        this.taskService = taskService;
        this.applicationEventPublisher = applicationEventPublisher;
        this.additionalInfo = additionalInfo;
        this.prefix = prefix;
        this.suffix = suffix;
        LOG.info("Wired Service additional info : {}", this.additionalInfo);
    }

    @Override
    public Iterable<Project> findAllIterable() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findAll() {
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding Project By Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        if (StringUtils.isEmpty(project.getId())) {
            project.setDateCreated(LocalDate.now());
        }
        updateInternalId(project);
        LOG.debug("Project Service >> Saving Project {}", project);
        Project savedProject = projectRepository.save(project);
        applicationEventPublisher.publishEvent(new ProjectCreatedEvent(savedProject.getId()));
        return savedProject;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
    }

    @Override
//    @Transactional
    @Transactional(rollbackFor = TaskNotSavedException.class)
    public void createProjectWithTasks() throws TaskNotSavedException {
        Project project = new Project("Project 1", LocalDate.now());
        Project newProject = save(project);

        Task task1 = new Task("Task 1", "Project 1 Task 1", LocalDate.now(), LocalDate.now().plusDays(7));
        taskService.save(task1);

        Set<Task> tasks = new HashSet<>();
        tasks.add(task1);

        newProject.setTasks(tasks);

        save(newProject);
    }

    @Override
    public Project addTasks(Project project, List<Task> tasks) {
        project.getTasks()
                .addAll(tasks.stream()
                        .filter(t -> !StringUtils.isEmpty(t.getName()))
                        .collect(Collectors.toList()));
        projectRepository.save(project);

        return project;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Iterable<Project> findByName(String name) {
        return projectRepository.findByNameContaining(name);
    }

    @Override
    public void throwsAnException() {
        throw new IllegalArgumentException("AOP Caught Exception");
    }


}
