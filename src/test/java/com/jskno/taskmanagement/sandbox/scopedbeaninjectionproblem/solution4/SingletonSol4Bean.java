package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonSol4Bean {

    Logger logger = LoggerFactory.getLogger(SingletonSol4Bean.class);

    private PrototypeSol4Bean prototypeSol4Bean;

    @Autowired
    public SingletonSol4Bean(PrototypeSol4Bean prototypeSol4Bean) {
        logger.info("Singleton instance created");
        this.prototypeSol4Bean = prototypeSol4Bean;
    }

    public PrototypeSol4Bean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        return prototypeSol4Bean;
    }

}
