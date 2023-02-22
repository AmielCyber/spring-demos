package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // Load the Spring Config file.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        // Retrieve bean from Spring Container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);
        // Check if they are the same.
        boolean result = (theCoach == alphaCoach);
        System.out.println("\nPointing to the same object " + result);
        System.out.println("\nMemory location for theCoach " + theCoach);
        System.out.println("\nMemory location for alphaCoach " + alphaCoach);
        // Close the context.
        context.close();
    }
}
