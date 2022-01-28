package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrototypeSol1Bean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol1Bean.class);

    public PrototypeSol1Bean() {
        logger.info("PrototypeBean Constructor: Prototype instance created");
    }
}
