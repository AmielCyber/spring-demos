package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

// Add the annotation to your java class so Spring can register this bean and specified the bean ID.
//@Component("thatSillyCoach") // Bean ID is "thatSillyCoach"
@Component  // Default bean id will be "tennisCoach"
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}
