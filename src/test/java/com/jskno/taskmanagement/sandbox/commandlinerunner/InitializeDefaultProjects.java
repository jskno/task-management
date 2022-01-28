package com.jskno.taskmanagement.sandbox.commandlinerunner;

import com.jskno.taskmanagement.sandbox.commandlinerunner.persistence.model.Project;
import com.jskno.taskmanagement.sandbox.commandlinerunner.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(2)
public class InitializeDefaultProjects implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(InitializeDefaultProjects.class);

    @Autowired
    IProjectService projectService;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("***************************************************************************");
        LOG.info("****************   SECOND INITIALIZATION  **********************************");
        LOG.info("***************************************************************************");

        projectService.save(new Project(1L,"My Third Project", LocalDate.now()));
        projectService.save(new Project("My Fourth Project", LocalDate.now()));
    }

}
