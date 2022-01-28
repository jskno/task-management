package com.jskno.taskmanagement.sandbox.componentscan.exclusions;

import com.jskno.taskmanagement.sandbox.componentscan.exclusions.animal.ExcFox;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.Arrays;

@Configuration
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = ExcFox.class),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.jskno\\.taskmanagement\\.componentscan\\.exclusions\\.flowers\\..*")
})
public class ExcComponentScanApp {

    private static ApplicationContext applicationContext;

    @Bean
    public ExcExampleBean excExampleBean() {
        return new ExcExampleBean();
    }

    public static void main(String[] args) {

        applicationContext = new AnnotationConfigApplicationContext(ExcComponentScanApp.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .forEach(beanName -> System.out.println(beanName));
    }
}
