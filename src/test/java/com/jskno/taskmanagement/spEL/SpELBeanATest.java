package com.jskno.taskmanagement.spEL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpELBeanATest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void testEsEL() {
        Assertions.assertNotNull(spELBeanA);
    }
}
