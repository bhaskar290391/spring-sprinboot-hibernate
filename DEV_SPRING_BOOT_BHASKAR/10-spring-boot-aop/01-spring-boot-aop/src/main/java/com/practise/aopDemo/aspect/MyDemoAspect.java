package com.practise.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoAspect {

    //@Before("execution(public void addAccount())")

    //@Before("execution(public void com.practise.aopDemo.dao.AccountDao.addAccount())")

    //@Before("execution(public void add*())")

    //@Before("execution(* add*(com.practise.aopDemo.model.Account))")

    //@Before("execution(* add*(com.practise.aopDemo.model.Account,..))")

    //@Before("execution(* add*(..))")

    @Before("execution(* com.practise.aopDemo.dao.*.*(..))")
    public void beforeAdviceAspect(){
        System.out.println("\n===> Executing @before advice for addAccount");
    }
}
