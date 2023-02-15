package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService{
    private final String[] fortuneArr = {
            "Today is going to be a great day.",
            "Today is going to be a sucky day.",
            "Today is going to be a meh day."
    };
    private final Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(fortuneArr.length);
        return fortuneArr[index];
    }
}
