package com.luv2code.springdemo;

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
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortuneArr.length);
        return fortuneArr[index];
    }
}
