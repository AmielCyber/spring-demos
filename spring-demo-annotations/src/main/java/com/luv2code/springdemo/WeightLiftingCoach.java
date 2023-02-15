package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component("gymBro")
public class WeightLiftingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "One more rep bro.";
    }
}
