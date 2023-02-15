package com.luv2code.springdemo;

public class WeightLiftingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "One more rep bro.";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
