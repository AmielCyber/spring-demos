package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // Read Spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        // Get the bean from Spring Container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
        // Call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        // Call method to get the daily fortune.
        System.out.println(theCoach.getDailyFortune());

        // Practice Activity.
        // Get the bean from Spring Container
        //Coach gymCoach = context.getBean("gymBro", Coach.class);
        // Call a method on the bean
        //System.out.println(gymCoach.getDailyWorkout());

        // Call our new swim coach methods ... has the props values injected.
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        // Close the context
        context.close();
    }
}
