package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.service.NoDDBBProjectService;
import com.jskno.taskmanagement.service.ProjectService;
import com.jskno.taskmanagement.service.TaskService;
import com.jskno.taskmanagement.web.converters.ProjectConverter;
import com.jskno.taskmanagement.web.dto.ProjectDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ProjectController.class,
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ProjectConverter.class))
public class ProjectControllerOnlyWebContextTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    NoDDBBProjectService noDDBBProjectService;

    @MockBean
    ProjectService projectService;

    @MockBean
    TaskService taskService;

    @Test
    public void whenProjectExists_thenGetSuccess() throws Exception {
        Mockito.when(projectService.findById(1L))
                .thenReturn(Optional.of(new Project(1L, "testName", LocalDate.now())));

        mockMvc.perform(get("/projects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testName"));
    }
}
