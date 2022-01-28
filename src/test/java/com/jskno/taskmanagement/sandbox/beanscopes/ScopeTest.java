package com.jskno.taskmanagement.sandbox.beanscopes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {

    @Test
    public void testingScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeAppConfig.class);
        IProjectServiceScopes projectService = context.getBean(IProjectServiceScopes.class);
        Assertions.assertTrue(projectService.getProjectRepository() == projectService.getSingletonBean());
        Assertions.assertTrue(projectService.getProjectRepository() != projectService.getPrototypeBean());
        Assertions.assertTrue(projectService.getProjectRepository() != projectService.getProjectRepository2());
        Assertions.assertTrue(projectService.getPrototypeBean() != projectService.getProjectRepository2());
    }
}
