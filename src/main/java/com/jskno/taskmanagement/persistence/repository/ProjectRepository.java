package com.jskno.taskmanagement.persistence.repository;

import com.jskno.taskmanagement.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>, ProjectRepositoryCustom {

    Optional<Project> findByName(String name);

    List<Project> findByDateCreatedBetween(LocalDate start, LocalDate end);

    Iterable<Project> findByNameContaining(String name);
}
