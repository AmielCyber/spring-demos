package com.amiel.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Creates a new bean instance for each container request
// Marks the class as a Spring Bean and will implement it when scanning
@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    // Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): " + this.getClass().getSimpleName());
    }
    // Define our destroy method
    @PreDestroy
    public void doMyDestroyStuff(){
        System.out.println("In doMyDestroyStuff(): " + this.getClass().getSimpleName());
    }
}
