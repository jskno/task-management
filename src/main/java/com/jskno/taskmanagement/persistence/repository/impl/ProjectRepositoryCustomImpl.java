package com.jskno.taskmanagement.persistence.repository.impl;

import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.repository.ProjectRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Project> findProjectsByNames(Set<String> names) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Project> query = cb.createQuery(Project.class);
        Root<Project> project = query.from(Project.class);

        Path<String> namePath = project.get("name");

        List<Predicate> predicates = new ArrayList<>();
        names.forEach(name -> predicates.add(cb.like(namePath, name)));
        query.select(project)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
