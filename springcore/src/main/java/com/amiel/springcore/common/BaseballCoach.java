package com.amiel.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Mark as Spring Bean
@Component
@Lazy   // Only initialize this object when called
public class BaseballCoach implements Coach{

    public  BaseballCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
