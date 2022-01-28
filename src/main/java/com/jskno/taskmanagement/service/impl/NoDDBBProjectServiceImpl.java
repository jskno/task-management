package com.jskno.taskmanagement.service.impl;

import com.jskno.taskmanagement.exception.TaskNotSavedException;
import com.jskno.taskmanagement.persistence.model.Project;
import com.jskno.taskmanagement.persistence.repository.NoDDBBProjectRepository;
import com.jskno.taskmanagement.persistence.repository.impl.NoDDBBProjectRepositoryImpl;
import com.jskno.taskmanagement.service.NoDDBBProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoDDBBProjectServiceImpl implements NoDDBBProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(NoDDBBProjectRepositoryImpl.class);

    private NoDDBBProjectRepository projectRepository;
    private String additionalInfo;

    @Autowired
    public NoDDBBProjectServiceImpl(
            NoDDBBProjectRepository projectRepository,
            @Value("${additional.serviceInfo}") String additionalInfo) {
        this.projectRepository = projectRepository;
        this.additionalInfo = additionalInfo;
        LOG.info("Wired Service additional info : {}", this.additionalInfo);
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Project Service >> Finding Project By Id {}", id);
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Project Service >> Saving Project {}", project);
        return projectRepository.save(project);
    }

}
