package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BeanFactory implements Function<String, PrototypeSol6Bean> {

    @Override
    public PrototypeSol6Bean apply(String name) {
        return new PrototypeSol6Bean(name);
    }
}
