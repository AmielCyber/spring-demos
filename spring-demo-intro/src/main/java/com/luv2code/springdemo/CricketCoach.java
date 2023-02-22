package com.luv2code.springdemo;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;
    // Add new fields for emailAddress and team;
    private String emailAddress;

    private String team;
    // Create a no-arg constructor.
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor.");
    }
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setTeam setter method.");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setEmailAddress setter method.");
        this.emailAddress = emailAddress;
    }

    // our setter method
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method.");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
