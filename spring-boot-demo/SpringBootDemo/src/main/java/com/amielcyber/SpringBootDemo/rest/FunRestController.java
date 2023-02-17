package com.amielcyber.SpringBootDemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    private String coachName;
    private String teamName;

    public FunRestController(@Value("${coach.name}") String coachName, @Value("${team.name}") String teamName){
        this.coachName = coachName;
        this.teamName = teamName;
    }
    // Expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a 10k now my dude.";
    }
    @GetMapping("/fortune")
    public String getDailyForturne(){
        return "Today is your lucky day!";
    }
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + this.coachName + ", " + this.teamName;
    }
}
