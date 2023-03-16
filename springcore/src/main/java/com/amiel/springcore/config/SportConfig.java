package com.amiel.springcore.config;

import com.amiel.springcore.common.Coach;
import com.amiel.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration
@Configuration
public class SportConfig {
    // Define a Bean method to configure the bean
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
