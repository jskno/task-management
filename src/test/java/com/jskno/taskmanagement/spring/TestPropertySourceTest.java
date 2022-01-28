package com.jskno.taskmanagement.spring;

import com.jskno.taskmanagement.TaskManagementApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = TaskManagementApplication.class)
@TestPropertySource("classpath:testAdditional.properties")
public class TestPropertySourceTest {

    @Value("${additional.serviceInfo}")
    private String serviceInfo;

    @Test
    public void testAdditionalPropertiesInjected() {
        // Here we are testing the original Spring context startup with a different property file injected
        // It´s working ok but I´d say all the beans in sandbox are being created at app startup ?????
    }


//    @Test
    public void whenTestPropertySource_thenValuesRetreived() {
        Assertions.assertEquals("From testing --> My service is broken !!.", serviceInfo);
    }


}
