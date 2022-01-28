package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol1App {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol1Config.class);

        SingletonSol1Bean firstSingleton = context.getBean(SingletonSol1Bean.class);
        PrototypeSol1Bean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol1Bean secondSingleton = context.getBean(SingletonSol1Bean.class);
        PrototypeSol1Bean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
