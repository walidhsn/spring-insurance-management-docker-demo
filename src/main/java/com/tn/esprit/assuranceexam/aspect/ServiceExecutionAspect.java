package com.tn.esprit.assuranceexam.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExecutionAspect {
    @Pointcut("execution(* com.tn.esprit.assuranceexam.serviceImpl.*.get*(..))")
    public void serviceGetMethods() {}
    @After("serviceGetMethods()")
    public void afterServiceMethodExecution() {
        System.out.println("===> Bon courage !");
    }
}
