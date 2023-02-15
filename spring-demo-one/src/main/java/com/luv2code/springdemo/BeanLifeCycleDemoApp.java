package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {
        // Load the Spring Config file.
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        // Retrieve bean from Spring Container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        // Use the bean
        System.out.println(theCoach.getDailyWorkout());
        // Close the context.
        context.close();
    }
}
