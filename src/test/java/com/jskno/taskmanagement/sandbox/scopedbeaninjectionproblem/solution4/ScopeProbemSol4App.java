package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol4App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol4Config.class);

        SingletonSol4Bean firstSingleton = context.getBean(SingletonSol4Bean.class);
        PrototypeSol4Bean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol4Bean secondSingleton = context.getBean(SingletonSol4Bean.class);
        PrototypeSol4Bean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
//        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
//        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
