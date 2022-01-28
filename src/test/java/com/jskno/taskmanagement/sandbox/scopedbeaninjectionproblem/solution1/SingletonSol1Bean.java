package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.time.LocalTime;

public class SingletonSol1Bean implements ApplicationContextAware {

    Logger logger = LoggerFactory.getLogger(SingletonSol1Bean.class);

    private ApplicationContext applicationContext;

    /*
    This is not needed anymore because Spring framework no longer injects the bean instance variable
    but it does by the method programmatically through the bean instance variable applicationContext that is injected.
    And there is not field any more becuase it is created from scratch whenever we want to use it.
    Only way to understand that is a prototype field. Different object at different use.
     */
//    @Autowired
//    private PrototypeSol1Bean prototypeBean;

    public SingletonSol1Bean() {
        logger.info("Singleton instance created");
    }

    public PrototypeSol1Bean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean method: " + String.valueOf(LocalTime.now()));
        return applicationContext.getBean(PrototypeSol1Bean.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
