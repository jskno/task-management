package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6_configClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.function.Function;

public class SingletonSol6Bean2 {

    Logger logger = LoggerFactory.getLogger(SingletonSol6Bean2.class);

    private Function<String, PrototypeSol6Bean2> beanFactory;

    @Autowired
    public SingletonSol6Bean2(Function<String, PrototypeSol6Bean2> beanFactory) {
        logger.info("Singleton instance created");
        this.beanFactory = beanFactory;
    }

    public PrototypeSol6Bean2 getPrototypeInstance(String name) {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        PrototypeSol6Bean2 bean = beanFactory.apply(name);
        return bean;
    }

}
