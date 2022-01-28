package com.jskno.taskmanagement.persistence.repository;

import com.jskno.taskmanagement.persistence.model.Project;

import java.util.List;
import java.util.Set;

public interface ProjectRepositoryCustom {

    List<Project> findProjectsByNames(Set<String> names);
}
