package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1_autowiringAppContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1_autowiringAppContext"})
public class ScopedProblemSol1AutowiringConfig {
}
