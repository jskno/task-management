package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1_autowiringAppContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeSol1AutowiringBean {

    Logger logger = LoggerFactory.getLogger(PrototypeSol1AutowiringBean.class);

    public PrototypeSol1AutowiringBean() {
        logger.info("PrototypeBean Constructor: Prototype instance created");
    }
}
