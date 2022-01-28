package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol3App {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol3Config.class);

        SingletonSol3Bean firstSingleton = context.getBean(SingletonSol3Bean.class);
        PrototypeSol3Bean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol3Bean secondSingleton = context.getBean(SingletonSol3Bean.class);
        PrototypeSol3Bean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
