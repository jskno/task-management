package com.jskno.taskmanagement.sandbox.beanscopes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@ComponentScan(basePackageClasses = {ScopeAppConfig.class})
public class ScopeAppConfig {

    @Bean
    @Primary
    public IProjectRepositoryScopes scopeSingletonBean() {
        return new ProjectRepositoryScopesImpl();
    }

    @Bean
//    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IProjectRepositoryScopes scopePrototypeBean() {
        return new ProjectRepositoryScopesImpl();
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        String result = list.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining());
        System.out.println(result);
        String jose = "";

    }
}
