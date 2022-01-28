package com.jskno.taskmanagement.persistence.repository;

import com.jskno.taskmanagement.persistence.model.Project;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProjectRepositoryIntegrationTest {
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());

        Assertions.assertNotNull(projectRepository.save(newProject));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());

        Assertions.assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());

        Assertions.assertEquals(retrievedProject.get(), newProject);
    }

    @Test
    public void givenProjectCreated_whenFindByDateCreatedBetween_thenSuccess() {
        Project pastProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(pastProject);

        Project todayProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(todayProject);

        Project tomorrowProject = new Project(randomAlphabetic(6), LocalDate.now().plusDays(1));
        projectRepository.save(tomorrowProject);

        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(
                LocalDate.now().minusDays(1), LocalDate.now().plusDays(5)
        );

        MatcherAssert.assertThat(retrievedProjects, CoreMatchers.hasItems(todayProject, tomorrowProject));
    }

    @Test
    public void givenProjectHasNoName_whenInvalidadEntityIsCreated_ThenConstraintException() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            projectRepository.save(new Project());
        });
    }

    @Test
    public void givenProjectHasNoName_whenInvalidadEntityIsCreated_ThenDataException() {
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            Project project = new Project();
            project.setName("Project Name");
            projectRepository.save(project);
        });
    }

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        MatcherAssert.assertThat(retrievedProjects.getContent(), IsCollectionWithSize.hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        Assertions.assertEquals(retrievedProjects, sortedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(
                PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));

        List<Project> sortedProjects = retrievedProjects.getContent().stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        Assertions.assertEquals(retrievedProjects.getContent(), sortedProjects);
        MatcherAssert.assertThat(retrievedProjects.getContent(), IsCollectionWithSize.hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindProjectsByNames_thenSuccess() {
        Set<String> names = new HashSet<>(Arrays.asList(
                "SpringSecurity Course", "SpringCore Course", "SpringCloud Course", "SpringMVC Course"));
        List<String> expectedResult = Arrays.asList("SpringSecurity Course", "SpringCore Course", "SpringCloud Course");

        List<Project> retrievedProjects = projectRepository.findProjectsByNames(names);

        MatcherAssert.assertThat(retrievedProjects, IsCollectionWithSize.hasSize(3));
        Assertions.assertTrue(retrievedProjects.stream().allMatch(project -> expectedResult.contains(project.getName())));

    }


}
