package com.practise.aopDemo.aspect;

import com.practise.aopDemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Order(3)
public class MyDemoAspect {


    @Around("execution(* com.practise.aopDemo.service.*.get*(..))")
    public String aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("\n===> Executing aroundAdvice for the aspect");
        long start= System.currentTimeMillis();

        Object data=joinPoint.proceed();

        long end=System.currentTimeMillis();

        long duration =(end-start)/1000;

        System.out.println("Duration for executing method"+duration);

        System.out.println("The Result from Aspect is"+data);

        return (String) data;
    }


    @After("execution(* com.practise.aopDemo.dao.*.find*(..))")
    public void afterFinallyadvice(){
        System.out.println("\n===> Executing @afterFinallyadvice advice for find account");

    }

    @AfterThrowing(pointcut = "execution(* com.practise.aopDemo.dao.*.find*(..))",throwing = "theEXc")
    public void afterThrowing(JoinPoint theJoinpoint,Throwable theEXc){
        System.out.println("\n===> Executing @AfterThrowing advice for find account");
        System.out.println("\n===> Exception in the advice "+ theEXc);
    }




    @AfterReturning(pointcut = "execution(* com.practise.aopDemo.dao.*.find*(..))",returning = "result")
    public void afterReturningAdvice(JoinPoint theJointpoint,List<Account> result){
        System.out.println("\n===> Executing @AfteReturning advice for find account");

        System.out.println("The result manipularion "+result);
        result.add(new Account(26,"platinum"));

    }

    @Before("com.practise.aopDemo.aspect.MainPointCutExpression.onlyMethodWithoutGetterSetter()")
    public void beforeAdviceAspect(JoinPoint joinpoint){
        System.out.println("\n===> Executing @before advice for addAccount");

        MethodSignature signature =(MethodSignature)joinpoint.getSignature();

        System.out.println("The signature ==>" +signature);

        Object[] args= joinpoint.getArgs();

        for (Object data:
             args) {
            System.out.println("The arguments data ==>"+data);
        }
    }

}
