package com.jskno.taskmanagement.sandbox.circulardependency.contextaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CircularDependencyAwareA implements ApplicationContextAware, InitializingBean {

    private CircularDependencyAwareB circularDependencyAwareB;

    private ApplicationContext applicationContext;

    public CircularDependencyAwareB getCircularDependencyAwareB() {
        System.out.println("Inside getCircularDependencyB");
        return circularDependencyAwareB;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        circularDependencyAwareB = applicationContext.getBean(CircularDependencyAwareB.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
