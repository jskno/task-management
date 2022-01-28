package com.jskno.taskmanagement.sandbox.processors.initializationcycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InitCycleBeanPostProcessor implements BeanPostProcessor {

    private static Logger LOG = LoggerFactory.getLogger(InitCycleBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("3. " + beanName);
        LOG.info("3. postProcessBeforeInitialization method: changing each bean object after construction and before initializing methods");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("6. " + beanName);
        LOG.info("6. postProcessAfterInitialization method: changing each bean object after initializing methods");
        return bean;
    }

}
