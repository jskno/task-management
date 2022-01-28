package com.jskno.taskmanagement.sandbox.propertiesfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBeanWithPropertyValue {

    private static final Logger LOG = LoggerFactory.getLogger(MyBeanWithPropertyValue.class);

    private String databaseUrl;
    private Integer databasePort;

    public MyBeanWithPropertyValue(
            @Value("${database.url}") String databaseUrl,
            @Value("${database.port}") Integer databasePort) {
        this.databaseUrl = databaseUrl;
        this.databasePort = databasePort;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public Integer getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(Integer databasePort) {
        this.databasePort = databasePort;
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("Database URL: " + getDatabaseUrl());
        LOG.info("Database Port: " + getDatabasePort());
    }
}
