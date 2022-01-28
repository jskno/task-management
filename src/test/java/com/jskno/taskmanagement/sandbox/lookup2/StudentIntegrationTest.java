package com.jskno.taskmanagement.sandbox.lookup2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentIntegrationTest {

    @Test
    public void whenLookupMethodCalled_thenNewInstanceReturned() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchoolConfig2.class);
        Student2 student1 = context.getBean("student2Bean", Student2.class);
        Student2 student2 = context.getBean("student2Bean", Student2.class);

        Assertions.assertEquals(student1, student2);
        Assertions.assertNotEquals(student1.getNotification("Alex"), student2.getNotification("Bethany"));
        context.close();
    }

    @Test
    public void whenAbstractGetterMethodInjects_thenNewInstanceReturned() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentServices2 services = context.getBean("studentServices2", StudentServices2.class);

        Assertions.assertEquals("PASS", services.appendMark("Alex", 76));
        Assertions.assertEquals("FAIL", services.appendMark("Bethany", 44));
        Assertions.assertEquals("PASS", services.appendMark("Claire", 96));
        context.close();
    }
}
