package com.jskno.taskmanagement.service;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.repository.NoDDBBProjectRepository;
import com.jskno.taskmanagement.service.impl.NoDDBBProjectServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class ProjectServiceUnitTest {

    @Mock
    NoDDBBProjectRepository projectRepository;

    @InjectMocks
    NoDDBBProjectServiceImpl projectService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenSavingProject_thenOK() {
        Project project = new Project("name", LocalDate.now());
        when(projectRepository.save(project)).thenReturn(project);

        Project savedProject = projectService.save(project);
        Assertions.assertNotNull(savedProject);
        Mockito.verify(projectRepository).save(project);
    }
}
