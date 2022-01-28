package com.jskno.taskmanagement.sandbox.applicationcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class ApplicationContextApp {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContextApp.class);

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationContextApp.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        LOG.info("ANNOTATION CONTEXT WITH ID '{}' SET", ctx.getId());
        AppContextIProjectService projectService = ctx.getBean(AppContextIProjectService.class);
        System.out.println(projectService.getName());

        LOG.info("Context active before close: {}", ctx.isActive());
        ctx.close();
        LOG.info("Context active after close: {}", ctx.isActive());
    }
}
