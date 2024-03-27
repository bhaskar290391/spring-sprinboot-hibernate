package com.practise.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudAnalyticAspect {

    @Before("com.practise.aopDemo.aspect.MainPointCutExpression.onlyMethodWithoutGetterSetter()")
    public void cloudAnalyticAdvice(){
        System.out.println("\n===> @before advice for Cloud");
    }
}
