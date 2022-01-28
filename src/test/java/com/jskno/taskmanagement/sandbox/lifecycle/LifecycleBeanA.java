package com.jskno.taskmanagement.sandbox.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBeanA {

    private static Logger log = LoggerFactory.getLogger(LifecycleBeanA.class);

    @PostConstruct
    public void init() {
        log.info("Inside init of LifecycleBeanA");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Inside preDestroy of LifecycleBeanA");
    }
}
