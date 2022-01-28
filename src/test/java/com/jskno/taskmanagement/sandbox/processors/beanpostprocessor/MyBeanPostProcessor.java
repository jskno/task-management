package com.jskno.taskmanagement.sandbox.processors.beanpostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private static Logger log = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    private MyDependencyBeanPostProcessor myDependencyBeanPostProcessor;

    public MyBeanPostProcessor(MyDependencyBeanPostProcessor myDependencyBeanPostProcessor) {
        log.info("MyBeanPostProcessor constructor");
        this.myDependencyBeanPostProcessor = myDependencyBeanPostProcessor;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization. Before initialising the bean: {}", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization. After initialising the bean: {}", beanName);
        return bean;
    }

    @PostConstruct
    public void init() {
        log.info("init. Before initialising the bean");
    }
}
