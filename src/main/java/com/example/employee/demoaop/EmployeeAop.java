package com.example.employee.demoaop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class EmployeeAop {
//    @Before("execution(public String getName())")
//    public void getNameAdviceBefore(){
//        System.out.println("Executing advice before on getName()");
//    }

//    @Before("execution(* com.example.employee.demoaop.*.*(..))")
//    public void getAllAdvice(){
//        System.out.println("All method called");
//    }

//    @After("execution(public String getName())")
//    public void getNameAdviceAfter(){
//        System.out.println("Executing advice after on getName()");
//    }
//
//    @AfterThrowing("execution(* com.example.employee.demoaop.*.*(..))")
//    public void getAdviceAfterThrowing(){
//        System.out.println("Executing advice afterThrowing");
//    }
    @Around("execution(public String getName())")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("before invoking getName() method");
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("After invoking getName() method. value: "+ object);
        return object;
    }
}
