package com.jskno.taskmanagement.sandbox.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackageClasses = ProfileConf.class)
@PropertySource("classpath:profiles.properties")
public class ProfileConf {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileConf.class);


    @Autowired
    private Environment environment;

    @PostConstruct
    public void postConstruct() {
        LOG.info("Active Profiles: {}", environment.getActiveProfiles());
        LOG.info("Default Profiles: {}", environment.getDefaultProfiles());
    }
}
