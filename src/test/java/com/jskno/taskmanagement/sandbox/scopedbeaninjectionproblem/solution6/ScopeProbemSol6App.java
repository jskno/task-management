package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol6App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol6Config.class);

        SingletonSol6Bean firstSingleton = context.getBean(SingletonSol6Bean.class);
        PrototypeSol6Bean firstPrototype = firstSingleton.getPrototypeInstance("Jose");

        // get singleton bean instance one more time
        SingletonSol6Bean secondSingleton = context.getBean(SingletonSol6Bean.class);
        PrototypeSol6Bean secondPrototype = secondSingleton.getPrototypeInstance("Jose");

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeInstance("Alvaro").equals(firstSingleton.getPrototypeInstance("Eva")),
                "A different instance should be returned");
    }
}
