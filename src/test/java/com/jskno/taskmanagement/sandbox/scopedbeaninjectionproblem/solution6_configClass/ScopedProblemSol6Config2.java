package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6_configClass;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.function.Function;

@Configuration
public class ScopedProblemSol6Config2 {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeSol6Bean2 prototypeSol6Bean2(String name) {
        return new PrototypeSol6Bean2(name);
    }

    @Bean
    public Function<String, PrototypeSol6Bean2> beanFactory2() {
        return name -> prototypeSol6Bean2(name);
    }

    @Bean
    public SingletonSol6Bean2 singletonSol6Bean2() {
        return new SingletonSol6Bean2(beanFactory2());
    }
}
