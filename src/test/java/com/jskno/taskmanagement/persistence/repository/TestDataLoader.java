package com.jskno.taskmanagement.persistence.repository;

import com.jskno.taskmanagement.persistence.model.Project;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class TestDataLoader {

    @Autowired
    private ProjectRepository projectRepository;

    @PostConstruct
    public void init() {
        projectRepository.save(new Project(RandomStringUtils.randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(RandomStringUtils.randomAlphabetic(6), LocalDate.now()));

        projectRepository.save(new Project("SpringCore Course", LocalDate.now()));
        projectRepository.save(new Project("SpringSecurity Course", LocalDate.now()));
        projectRepository.save(new Project("SpringWeb Course", LocalDate.now()));
        projectRepository.save(new Project("SpringCloud Course", LocalDate.now()));
    }


}
