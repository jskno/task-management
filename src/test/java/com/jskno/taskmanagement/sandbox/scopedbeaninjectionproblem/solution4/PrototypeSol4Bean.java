package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeSol4Bean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol4Bean.class);

    public PrototypeSol4Bean() {
        logger.info("PrototypeBean Constructor: Prototype instance created");
    }
}
