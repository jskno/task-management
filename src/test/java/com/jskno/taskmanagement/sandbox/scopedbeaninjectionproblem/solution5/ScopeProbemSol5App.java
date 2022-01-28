package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol5App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol5Config.class);

        SingletonSol5Bean firstSingleton = context.getBean(SingletonSol5Bean.class);
        PrototypeSol5Bean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol5Bean secondSingleton = context.getBean(SingletonSol5Bean.class);
        PrototypeSol5Bean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
