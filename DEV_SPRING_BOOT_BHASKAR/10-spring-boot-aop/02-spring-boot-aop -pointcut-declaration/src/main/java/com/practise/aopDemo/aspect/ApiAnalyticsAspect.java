package com.practise.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {


    @Before("com.practise.aopDemo.aspect.MainPointCutExpression.onlyMethodWithoutGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n===> performing API analytic");
    }
}
