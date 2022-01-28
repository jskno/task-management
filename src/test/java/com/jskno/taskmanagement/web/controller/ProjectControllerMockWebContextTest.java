package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class ProjectControllerMockWebContextTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ProjectService projectService;

//    @Test
    public void whenWebEnvIsInstantiated_thenOK() {
    }

//    @Test
    public void whenProjectExists_thenGetSuccess() throws Exception {
        
        Project savedProject = projectService.save(new Project("test Project 45632", LocalDate.now()));

        mockMvc.perform(get("/projects/" + savedProject.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test Project 45632"));
    }
}
