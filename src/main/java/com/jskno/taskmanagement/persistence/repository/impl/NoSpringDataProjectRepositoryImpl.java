package com.jskno.taskmanagement.persistence.repository.impl;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.repository.NoSpringDataProjectRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class NoSpringDataProjectRepositoryImpl implements NoSpringDataProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Project> findById(Long id) {
        Project project = entityManager.find(Project.class, id);
        return Optional.ofNullable(project);
    }

    @Override
    @Transactional
    public Project save(Project project) {
        entityManager.persist(project);
        return project;
    }
}
