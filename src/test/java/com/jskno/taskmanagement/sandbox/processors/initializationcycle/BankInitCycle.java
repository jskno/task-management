package com.jskno.taskmanagement.sandbox.processors.initializationcycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class BankInitCycle implements InitializingBean {

    private static Logger log = LoggerFactory.getLogger(BankInitCycle.class);

    private String bankName;

    public BankInitCycle() {
        log.info("2. Constructor method: creating the bean object");
        log.info("value of the property bankName is: {}", this.bankName);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @PostConstruct
    public void init() {
        log.info("4. PostConstruct method: first init method call only for this particular bean object");
        log.info("value of the property bankName is: {}", this.bankName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("5. afterPropertiesSet method: second init method call only for this particular bean object");
    }
}
