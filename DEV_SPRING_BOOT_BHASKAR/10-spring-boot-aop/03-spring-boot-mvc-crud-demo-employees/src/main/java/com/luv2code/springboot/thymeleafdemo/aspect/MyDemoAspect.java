package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoAspect {

    Logger logger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerAdvice(){};

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void service(){};

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void dao(){};

    @Pointcut("controllerAdvice() || service() || dao()")
    public void appWorkFlow(){};

    @Before("appWorkFlow()")
    public void beforeAdviceForApp(JoinPoint joinpoint){

        logger.info("==> Executing @Before Advice for Application for method"+joinpoint.getSignature().toShortString());

        Object[] arg=joinpoint.getArgs();

        for (Object argument:
        arg) {
        logger.info("===> "+ argument);
        }
    }
    @AfterReturning(pointcut = "appWorkFlow()",returning = "result")
    public void afterAdviceForApp(JoinPoint joinpoint,Object result){

        logger.info("==> Executing @After Advice for Application for method"+joinpoint.getSignature().toShortString());

        logger.info("Result  for after Returning advice is "+result);
    }

}
