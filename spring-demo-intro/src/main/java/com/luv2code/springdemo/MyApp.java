package com.luv2code.springdemo;

public class MyApp {
    public static void main(String[] args){
        // Create the obj
        Coach theCoach = new WeightLiftingCoach();
        // Use the obj
        System.out.println(theCoach.getDailyWorkout());
    }
}
