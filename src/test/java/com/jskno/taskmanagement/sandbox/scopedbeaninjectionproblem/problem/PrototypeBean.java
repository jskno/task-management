package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.problem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeBean {

    Logger logger = LoggerFactory.getLogger(PrototypeBean.class);

    public PrototypeBean() {
        logger.info("Prototype instance created");
    }
}
