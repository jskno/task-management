package com.jskno.taskmanagement.sandbox.lookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestingLookup {

    /*
    With this test we are showing how to inject a PROTOTYPE BEAN into a SINGLETON BEAN
    using Lookup annotations.
     */
    @Test
    public void whenLookupMethodCalled_thenNewInstanceReturned() throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolConfig.class);
        StudentServices firstStudentServices = context.getBean(StudentServices.class);
        StudentServices secondStudentServices = context.getBean(StudentServices.class);

        Assertions.assertEquals(firstStudentServices, secondStudentServices);
        Assertions.assertNotEquals(firstStudentServices.getNotification(), secondStudentServices.getNotification());

        SchoolNotification notification = firstStudentServices.getNotification();
        Thread.sleep(2000);
        SchoolNotification notification2 = firstStudentServices.getNotification();
        Thread.sleep(2000);
        SchoolNotification notification3 = firstStudentServices.getNotification();
        Thread.sleep(2000);
        SchoolNotification notification4 = firstStudentServices.getNotification();
        Assertions.assertNotEquals(notification.getCreationDate(), notification2.getCreationDate());
        Assertions.assertNotEquals(notification2.getCreationDate(), notification3.getCreationDate());
        Assertions.assertNotEquals(notification3.getCreationDate(), notification4.getCreationDate());
        Assertions.assertNotEquals(notification.getCreationDate(), notification4.getCreationDate());

        Student student1 = new Student(1, "Jose");
        Student student2 = new Student(2, "Raquel");
        firstStudentServices.mark(student1, "Maths", "PASS");
        firstStudentServices.mark(student2, "Geography", "PASS");

        System.out.println(student1);
        System.out.println(student2);

    }
}
