package com.jskno.taskmanagement.aop;

import com.jskno.taskmanagement.persistence.model.Project;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

/*
The main components in AOP:

    * the Aspect, is, simply put, the actual cross-cutting logic that we want to add
    * the Join Point, the point during execution of a program where we can hook in our logic to run
    * the Point Cut, a way to match one or more join points and, as a result,
        determine where the logic is going to actually run
    * the Advice, this is the infrastructure around a join-point that runs the Aspect
        at that Join-Point; in practical terms, this is an interceptor
 */

// The ASPECT is this class
@Aspect
@Component
public class ProjectServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceAspect.class);

    @Before(
        // This expression represents the POINTCUT
        "execution(* com.jskno.taskmanagement.service.impl.ProjectServiceImpl.findById(Long))")
    public void before(JoinPoint joinPoint) {
        // The JOINTPOINT is introduced here as an argument and it's the real
        // findById method called on ProjectServiceImpl with its args
        LOG.info("Searching Project with Id {}", joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "execution(*..Optional<*..Project>  *..service..findById(*))",
            returning = "project")
    public void afterReturningProject(Optional<Project> project) {
        LOG.info("project found: {}", project.orElse(null));
    }

    @After("within(com.jskno.taskmanagement.service.impl.ProjectServiceImpl)")
    public void afterAllMethodsOfProjectServiceImpl(JoinPoint joinPoint) {
        LOG.info("After Invoking the method: {} ", joinPoint.getSignature().getName());
    }

    @Around("execution(* com.jskno.taskmanagement.service.impl.ProjectServiceImpl.save(*))")
    public Object aroundSave(ProceedingJoinPoint joinPoint) {
        Object val = joinPoint.getArgs()[0];
        try {
            LOG.info("saving project : {}", val);
            val = joinPoint.proceed();
            LOG.info("project saved successfully !!");
        } catch (Throwable e) {
            LOG.error("error while saving project: ", e);
        }
        return val;
    }

    @AfterThrowing(pointcut =
            "execution(* com.jskno.taskmanagement.service.impl.ProjectServiceImpl.throwsAnException())",
            throwing = "ex")
    public void afterThrowingException(IllegalArgumentException ex) throws Throwable {
        LOG.info("After Invoking the method: {} ", ex.getMessage());
    }


}
