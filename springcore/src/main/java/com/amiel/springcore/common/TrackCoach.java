package com.amiel.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Mark as a Spring Bean
// Default scope is Singleton
@Component
@Primary        // Marks as primary which will be the one to use if not specified
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }
}
