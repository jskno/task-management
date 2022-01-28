package com.jskno.taskmanagement.sandbox.scopedbeaninjectionproblem.solution1_autowiringAppContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeProbemSol1AutowiringApp {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ScopedProblemSol1AutowiringConfig.class);

        SingletonSol1AutowiringBean firstSingleton = context.getBean(SingletonSol1AutowiringBean.class);
        PrototypeSol1AutowiringBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonSol1AutowiringBean secondSingleton = context.getBean(SingletonSol1AutowiringBean.class);
        PrototypeSol1AutowiringBean secondPrototype = secondSingleton.getPrototypeBean();

        Assert.isTrue(firstSingleton.equals(secondSingleton), "The same instance should be returned");
        Assert.isTrue(!firstPrototype.equals(secondPrototype), "A different instance should be returned");
        Assert.isTrue(!firstSingleton.getPrototypeBean().equals(firstSingleton.getPrototypeBean()), "A different instance should be returned");
    }
}
