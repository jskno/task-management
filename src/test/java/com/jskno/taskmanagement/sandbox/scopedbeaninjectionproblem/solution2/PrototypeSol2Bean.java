package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeSol2Bean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol2Bean.class);

    public PrototypeSol2Bean() {
        logger.info("PrototypeBean Constructor: Prototype instance created");
    }
}
