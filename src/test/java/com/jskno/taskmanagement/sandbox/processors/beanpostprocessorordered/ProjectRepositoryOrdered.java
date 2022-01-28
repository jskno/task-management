package com.jskno.taskmanagement.sandbox.processors.beanpostprocessorordered;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ProjectRepositoryOrdered implements BeanPostProcessor, Ordered {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectRepositoryOrdered.class);

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("ProjectRepository: Inside postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("ProjectRepository: Inside postProcessAfterInitialization");
        return bean;
    }
}
