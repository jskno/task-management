package com.jskno.taskmanagement.web.controller;

import com.jskno.taskmanagement.web.dto.ProjectDto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootTest
public class ProjectRestApiLiveTest {

    private static final String BASE_URL = "http://localhost:8081/projects/";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void givenProjectExists_whenGet_thenSuccess() {
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + "1", ProjectDto.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void givenNewProject_whenCreate_thenSuccess() {
        ProjectDto projectDto = new ProjectDto("My Test Project 2", LocalDate.now());
        ResponseEntity<ProjectDto> response = restTemplate.postForEntity(BASE_URL, projectDto, ProjectDto.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(HttpStatus.CREATED.value()));
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void givenExistsProject_whenDelete_thenSuccess() {
        ProjectDto projectDto = new ProjectDto("My Delete Test Project 3", LocalDate.now());
        ResponseEntity<ProjectDto> responseCreate = restTemplate.postForEntity(BASE_URL, projectDto, ProjectDto.class);

        MatcherAssert.assertThat(responseCreate.getStatusCodeValue(), Matchers.equalTo(HttpStatus.CREATED.value()));
        Assertions.assertNotNull(responseCreate.getBody());

        ResponseEntity<ProjectDto> responseFind = restTemplate.getForEntity(BASE_URL + responseCreate.getBody().getId(), ProjectDto.class);

        MatcherAssert.assertThat(responseFind.getStatusCodeValue(), Matchers.equalTo(200));
        Assertions.assertNotNull(responseFind.getBody());
        Assertions.assertEquals(responseFind.getBody().getId(), responseFind.getBody().getId());

        restTemplate.delete(BASE_URL + responseCreate.getBody().getId());

//        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL + responseCreate.getBody().getId(), ProjectDto.class);
//
//        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
//        Assertions.assertNull(response.getBody());
    }

}
