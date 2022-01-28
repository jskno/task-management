package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.function.Function;

@Component
public class SingletonSol6Bean {

    Logger logger = LoggerFactory.getLogger(SingletonSol6Bean.class);

    private Function<String, PrototypeSol6Bean> beanFactory;

    @Autowired
    public SingletonSol6Bean(Function<String, PrototypeSol6Bean> beanFactory) {
        logger.info("Singleton instance created");
        this.beanFactory = beanFactory;
    }

    public PrototypeSol6Bean getPrototypeInstance(String name) {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        PrototypeSol6Bean bean = beanFactory.apply(name);
        return bean;
    }

}
