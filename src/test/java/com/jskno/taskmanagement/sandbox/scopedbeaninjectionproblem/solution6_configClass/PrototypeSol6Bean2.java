package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6_configClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeSol6Bean2 {

    Logger logger = LoggerFactory.getLogger(PrototypeSol6Bean2.class);

    private String name;

    public PrototypeSol6Bean2(String name) {
        this.name = name;
        logger.info("PrototypeBean Constructor: Prototype instance " + name + " created");
    }
}
