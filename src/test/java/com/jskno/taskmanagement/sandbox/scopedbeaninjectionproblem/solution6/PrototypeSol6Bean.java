package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeSol6Bean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol6Bean.class);

    private String name;

    public PrototypeSol6Bean(String name) {
        this.name = name;
        logger.info("PrototypeBean Constructor: Prototype instance " + name + " created");
    }
}
