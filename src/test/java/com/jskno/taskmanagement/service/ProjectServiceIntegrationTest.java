package com.jskno.taskmanagement.service;

import com.jskno.taskmanagement.persistence.model.Project;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

@SpringJUnitConfig(classes = IntegrationTestConfig.class)
public class ProjectServiceIntegrationTest {

    @Autowired
    private NoDDBBProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project(null, "Any name", LocalDate.now()));

        MatcherAssert.assertThat(savedProject, CoreMatchers.is(CoreMatchers.notNullValue()));
        Assertions.assertNotNull(savedProject.getInternalId());
        Assertions.assertTrue(savedProject.getInternalId().startsWith("PRO"));
        Assertions.assertTrue(savedProject.getInternalId().endsWith("123"));
    }
}
