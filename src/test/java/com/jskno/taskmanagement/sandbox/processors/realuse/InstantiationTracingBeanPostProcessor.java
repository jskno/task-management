package com.jskno.taskmanagement.sandbox.processors.realuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    private static Logger LOGGER = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    // simply return the instantiated bean as-is
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("InstantiationTracingBeanPostProcessor: Inside postProcessBeforeInitialization");
        return bean; // we could potentially return any object reference here...
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.info("InstantiationTracingBeanPostProcessor: Inside postProcessAfterInitialization");
        LOGGER.info("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }
}
