package com.jskno.taskmanagement.sandbox.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileTest {

    @Test
    public void testingProfiles() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProfileConf.class);
        IProfileProjectRepository projectRepository = context.getBean(IProfileProjectRepository.class);
        projectRepository.findById(3L);
    }
}
