package com.jskno.taskmanagement.sandbox.processors.staticmethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class ProjectServiceStatic implements BeanPostProcessor, Ordered {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjectServiceStatic.class);

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("ProjectService: Inside postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("ProjectService: Inside postProcessAfterInitialization");
        return bean;
    }
}
