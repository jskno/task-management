package com.jskno.taskmanagement.sandbox.beanscopes;

public interface IProjectServiceScopes {

    IProjectRepositoryScopes getProjectRepository();

    IProjectRepositoryScopes getSingletonBean();

    IProjectRepositoryScopes getPrototypeBean();

    IProjectRepositoryScopes getProjectRepository2();
}
