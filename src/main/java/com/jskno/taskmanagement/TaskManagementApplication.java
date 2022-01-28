package com.jskno.taskmanagement;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.service.NoDDBBProjectService;
import com.jskno.taskmanagement.service.ProjectService;
import com.jskno.taskmanagement.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class TaskManagementApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TaskManagementApplication.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    NoDDBBProjectService noDDBBProjectService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TaskService taskService;

    @Value("${additional.info}")
    private String additionalInfo;

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {

        LOG.info("***************************************************************************");
        LOG.info("****************   BEAN NAMES   *******************************************");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(beanName -> LOG.info(beanName));
        LOG.info("Number of beans : " + context.getBeanDefinitionNames().length);
        LOG.info("***************************************************************************");

        LOG.info("Additional Property: {}", additionalInfo);

        noDDBBProjectService.save(new Project(null,"My First Project", LocalDate.now()));
        noDDBBProjectService.save(new Project(null, "My Second Project", LocalDate.now()));

        Optional<Project> optionalProject = noDDBBProjectService.findById(1L);
        optionalProject.ifPresent(System.out::println);

        try {
            projectService.createProjectWithTasks();
        } catch (Exception e) {
            LOG.error("Error occurred in creating project with tasks", e);
        }

        LOG.info("Fetching all Projects");
        projectService.findAll()
                .forEach(p -> LOG.info(p.toString()));

        LOG.info("Fetching all tasks");
        taskService.findAll()
                .forEach(t -> LOG.info(t.toString()));
    }

}
