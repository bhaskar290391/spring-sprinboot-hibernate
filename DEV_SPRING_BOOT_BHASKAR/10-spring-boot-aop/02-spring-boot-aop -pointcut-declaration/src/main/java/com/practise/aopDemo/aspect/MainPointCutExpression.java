package com.practise.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MainPointCutExpression {


    @Pointcut("execution(* com.practise.aopDemo.dao.*.*(..))")
    public void doaPackage(){};

    @Pointcut("execution(* com.practise.aopDemo.dao.*.get*(..))")
    public void getter(){};

    @Pointcut("execution(* com.practise.aopDemo.dao.*.set*(..))")
    public void setter(){};

    @Pointcut("doaPackage() && !(getter() || setter())")
    public void onlyMethodWithoutGetterSetter(){};

}
