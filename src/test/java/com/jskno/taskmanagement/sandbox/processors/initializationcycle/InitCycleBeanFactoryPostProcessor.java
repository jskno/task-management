package com.jskno.taskmanagement.sandbox.processors.initializationcycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class InitCycleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static Logger log = LoggerFactory.getLogger(InitCycleBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("1. postProcessBeanFactory method: first modifying metadata beans definition.");
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("bankInitCycle");
        bd.getPropertyValues().add("bankName", "Open Bank");
    }
}
