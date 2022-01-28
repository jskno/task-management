package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol2App {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol2Config.class);

        SingletonSol2Bean firstSingleton = context.getBean(SingletonSol2Bean.class);
        PrototypeSol2Bean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol2Bean secondSingleton = context.getBean(SingletonSol2Bean.class);
        PrototypeSol2Bean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
