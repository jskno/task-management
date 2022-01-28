package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1_autowiringAppContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SingletonSol1AutowiringBean {

    Logger logger = LoggerFactory.getLogger(SingletonSol1AutowiringBean.class);

    private ApplicationContext applicationContext;

    @Autowired
    public SingletonSol1AutowiringBean(ApplicationContext applicationContext) {
        logger.info("Singleton instance created");
        this.applicationContext = applicationContext;
    }

    public PrototypeSol1AutowiringBean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean method: " + LocalTime.now());
        return applicationContext.getBean(PrototypeSol1AutowiringBean.class);
    }

}
