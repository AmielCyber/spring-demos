package com.amiel.springcore.rest;

import com.amiel.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DemoController {
    // Define a private field for dependency
    private final Coach coach;
    // private final Coach anotherCoach;
    // Constructor Injection recommended for required injections
    // With qualifier to specify which spring bean to use
    // @Autowired
    // public DemoController(@Qualifier("cricketCoach")Coach coach, @Qualifier("cricketCoach") Coach anotherCoach) {
    //    System.out.println("In constructor: " + this.getClass().getSimpleName());
    //    this.coach = coach;
    //    this.anotherCoach = anotherCoach;
    // }

    // Setter Injection recommended for optional injections
    // @Autowired
    // public void setCoach(Coach coach){
    //    this.coach = coach;
    // }

    // Constructor Injection recommended for required injections
    // With qualifier to specify which spring bean to use
    @Autowired
    public DemoController(@Qualifier("aquatic")Coach coach) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        this.coach = coach;
    }

    // Constructor Injection recommended for required injections
    //    @Autowired
    //    public DemoController(Coach coach) {
    //        this.coach = coach;
    //    }

    // Map dailyworkout controller
    @GetMapping("/dailyworkout")
    private String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }
}
