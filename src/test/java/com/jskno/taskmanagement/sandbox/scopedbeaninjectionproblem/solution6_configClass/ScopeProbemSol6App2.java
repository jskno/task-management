package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6_configClass;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol6App2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol6Config2.class);

        SingletonSol6Bean2 firstSingleton = context.getBean(SingletonSol6Bean2.class);
        PrototypeSol6Bean2 firstPrototype = firstSingleton.getPrototypeInstance("Jose");

        // get singleton bean instance one more time
        SingletonSol6Bean2 secondSingleton = context.getBean(SingletonSol6Bean2.class);
        PrototypeSol6Bean2 secondPrototype = secondSingleton.getPrototypeInstance("Jose");

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeInstance("Alvaro").equals(firstSingleton.getPrototypeInstance("Eva")),
                "A different instance should be returned");
    }
}
