package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonSol2Bean {

    Logger logger = LoggerFactory.getLogger(SingletonSol2Bean.class);

    public SingletonSol2Bean() {
        logger.info("Singleton instance created");
    }

    @Lookup
    public PrototypeSol2Bean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        return null;
    }

}
