package com.jskno.taskmanagement.sandbox.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleBeanB {

    private static Logger log = LoggerFactory.getLogger(LifecycleBeanB.class);

    public void init() {
        log.info("Inside init of LifecycleBeanB");
    }

    public void preDestroy() {
        log.info("Inside preDestroy of LifecycleBeanB");
    }
}
