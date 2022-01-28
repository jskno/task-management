package com.jskno.taskmanagement.sandbox.unsatisfieddependency;

import com.jskno.taskmanagement.sandbox.unsatisfieddependency.service.PurchaseDeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PurchaseApp {

    /*
    This main method can give rise to UnsatisfiedDependencyException by 3 different causes
    1. If we remove the @Repository annotation of ShoeRepository
    2. If we scan only service package and app will not find RunnerRepository
    3. If we do not add @Qualifier to inverntoryRepository variable instance from Service
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PurchaseAppConfig.class);
        PurchaseDeptService purchaseDeptService = context.getBean(PurchaseDeptService.class);
    }
}
