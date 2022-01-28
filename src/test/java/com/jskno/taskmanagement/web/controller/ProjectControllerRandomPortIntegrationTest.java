package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.TaskManagementApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TaskManagementApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerRandomPortIntegrationTest {

    @Test
    public void whenWebEnvIsInstantiated_thenOK() {

    }
}
