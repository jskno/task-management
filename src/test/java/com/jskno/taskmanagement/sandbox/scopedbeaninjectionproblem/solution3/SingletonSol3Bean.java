package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

import java.time.LocalTime;

@Component
public class SingletonSol3Bean {

    Logger logger = LoggerFactory.getLogger(SingletonSol3Bean.class);

    private Provider<PrototypeSol3Bean> prototypeSol3BeanProvider;

    @Autowired
    public SingletonSol3Bean(Provider<PrototypeSol3Bean> prototypeSol3BeanProvider) {
        logger.info("Singleton instance created");
        this.prototypeSol3BeanProvider = prototypeSol3BeanProvider;
    }

    public PrototypeSol3Bean getPrototypeBean() {
        logger.info("Singleton Bean getPrototypeBean Lookup method: " + LocalTime.now());
        return this.prototypeSol3BeanProvider.get();
    }

}
