package com.jskno.taskmanagement.sandbox.applicationcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AppContextProjectServiceImpl implements AppContextIProjectService, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(AppContextProjectServiceImpl.class);

    private String name = "Whatever !!";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG.info("CONTEXT WITH ID '{}' SET", applicationContext.getId());
    }

    @Override
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        LOG.info("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("PreDestroy");
    }
}
