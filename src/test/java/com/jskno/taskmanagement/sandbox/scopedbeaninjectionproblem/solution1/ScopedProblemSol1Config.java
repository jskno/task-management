package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopedProblemSol1Config {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeSol1Bean prototypeSol1Bean() {
        return new PrototypeSol1Bean();
    }

    @Bean
    public SingletonSol1Bean singletonSol1Bean() {
        return new SingletonSol1Bean();
    }
}
