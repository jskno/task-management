package com.jskno.taskmanagement.sandbox.beanscopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProjectServiceScopesImpl implements IProjectServiceScopes {

    private static Logger log = LoggerFactory.getLogger(ProjectServiceScopesImpl.class);

    @Autowired
    private IProjectRepositoryScopes projectRepository;

    @Autowired
    private IProjectRepositoryScopes singletonBean;

    @Autowired
    @Qualifier("scopePrototypeBean")
    private IProjectRepositoryScopes prototypeBean;

    @Autowired
    @Qualifier("scopePrototypeBean")
    private IProjectRepositoryScopes projectRepository2;

    @PostConstruct
    public void afterInjection() {
        log.info("Inside afterInjection method ProjectServiceImpl");
    }

    @Override
    public IProjectRepositoryScopes getProjectRepository() {
        return projectRepository;
    }

    @Override
    public IProjectRepositoryScopes getSingletonBean() {
        return singletonBean;
    }

    @Override
    public IProjectRepositoryScopes getPrototypeBean() {
        return prototypeBean;
    }

    @Override
    public IProjectRepositoryScopes getProjectRepository2() {
        return projectRepository2;
    }
}
