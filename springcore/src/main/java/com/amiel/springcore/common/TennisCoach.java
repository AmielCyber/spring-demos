package com.amiel.springcore.common;

import org.springframework.stereotype.Component;

// Mark as a Spring Bean
@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}
