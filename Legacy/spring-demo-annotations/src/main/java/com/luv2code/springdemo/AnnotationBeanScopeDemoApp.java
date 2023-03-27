package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // Load Spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // Check if they are the same obj
        boolean result = (theCoach == alphaCoach);
        System.out.println("\n Pointing to the same obj: " + result);
        System.out.println("\n Memory location for theCoach: " + theCoach);
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach);

        // Close the context.
        context.close();
    }
}
