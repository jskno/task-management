package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonSol5Bean {

    Logger logger = LoggerFactory.getLogger(SingletonSol5Bean.class);

    private ObjectFactory<PrototypeSol5Bean> prototypeSol5BeanObjectFactory;

    @Autowired
    public SingletonSol5Bean(ObjectFactory<PrototypeSol5Bean> prototypeSol5BeanObjectFactory) {
        logger.info("Singleton instance created");
        this.prototypeSol5BeanObjectFactory = prototypeSol5BeanObjectFactory;
    }

    public PrototypeSol5Bean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        return prototypeSol5BeanObjectFactory.getObject();
    }

}
