package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Add the annotation to your java class so Spring can register this bean and specified the bean ID.
//@Component("thatSillyCoach") // Bean ID is "thatSillyCoach"
@Component  // Default bean id will be "tennisCoach"
public class TennisCoach implements Coach{
    @Autowired // Field injection. Not recommended. Spring recommends constructor injection.
    @Qualifier("fileFortuneService") //Be specific to which bean id to use. (same as classname but first letter lowercase.
    private FortuneService fortuneService;
    // Define a default constructor
    public TennisCoach(){
        System.out.println("Inside the default constructor of TennisCoach");
    }
    /*
    Autowired // Configure dependency setter injection. Not needed in Spring 4.3, if the target bean only defines 1 construct.
    public TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
     */
    /*
    @Autowired  // Can setter inject in any method name.
    public void doSomeCrazyStuff(FortuneService fortuneService){
        System.out.println("Inside the setFortuneService of TennisCoach");
        this.fortuneService = fortuneService;
    }
     */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
