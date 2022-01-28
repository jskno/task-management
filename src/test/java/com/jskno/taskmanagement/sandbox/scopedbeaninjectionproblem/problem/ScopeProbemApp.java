package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.problem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemApp {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemConfig.class);

        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(firstPrototype.equals(secondPrototype), "The same instance should be returned");
        Assert.isTrue(firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "The same instance should be returned");
    }
}
