package com.jskno.taskmanagement.sandbox.processors.beanfactorypostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class Bank {

    private static Logger log = LoggerFactory.getLogger(Bank.class);

    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @PostConstruct
    public void init() {
        log.info("value of the property foo is: {}", this.bankName);
    }
}
