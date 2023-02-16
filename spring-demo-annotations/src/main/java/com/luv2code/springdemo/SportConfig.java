package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configuration  // Tell beans is the config file
// Commenting ComponentScan will only add components that we manually define.
//@ComponentScan("com.luv2code.springdemo") // Add component scanning support. Scans all classes with @Component.
@PropertySource("classpath:myLogger.properties") // Property source for value injection.
@PropertySource("classpath:sport.properties") // Property source for value injection.
public class SportConfig {
    /**
     * Logger Configuration.
     */
    @Bean
    public MyLoggerConfig2 myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {

        return new MyLoggerConfig2(rootLoggerLevel, printedLoggerLevel);
    }

    // define bean for our sad fortune service
    // Method name will be the bean id. Spring will use for the container
    // Spring creates a bean component manually with bean id of "sadFortuneService
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    // define bean for our swim coach AND inject dependency
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
