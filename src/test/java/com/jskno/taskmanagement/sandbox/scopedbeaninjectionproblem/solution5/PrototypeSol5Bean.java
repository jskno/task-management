package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeSol5Bean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol5Bean.class);

    public PrototypeSol5Bean() {
        logger.info("PrototypeBean Constructor: Prototype instance created");
    }
}
