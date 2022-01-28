package com.jskno.taskmanagement.spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{'Learn' + 'Spring'}")
    private String sentence;

    @Value("#{2 == 2}")
    private boolean isTrue;

    @Value("#{spELBeanB.property1}")
    private int otherBeanProperty;
}
