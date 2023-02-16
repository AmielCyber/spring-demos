package com.luv2code.springdemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FileFortuneService implements FortuneService{
    private final String[] fortuneArr;
    private final Random myRandom;

    public FileFortuneService(@Value("${file.fortune}") String[] fortuneArr){
        this.fortuneArr = fortuneArr;
        this.myRandom = new Random();
    }
    @PostConstruct
    public static void doMyStartupStuff(){
        System.out.println("FileFortune: inside of doMyStartupStuff");
    }
    @PreDestroy
    public static void doMyCleanupStuff(){
        System.out.println("FileFortune: inside of doMyCleanupStuff");
    }
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortuneArr.length);
        return fortuneArr[index];
    }
}
