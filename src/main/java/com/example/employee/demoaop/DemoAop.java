package com.example.employee.demoaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAop {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"aop-cfg.xml"});

        EmployeeTest employeeTest = (EmployeeTest) applicationContext.getBean("employeeTest");

        System.out.println("--------------getName()--------------");
        employeeTest.getName();

        System.out.println("-------------setName()---------------");
        employeeTest.setName("test aop");

        System.out.println("----------------Throw--------------");
        employeeTest.printThrowException();
    }
}
