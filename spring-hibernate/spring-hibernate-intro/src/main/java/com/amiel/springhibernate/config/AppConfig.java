package com.amiel.springhibernate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  // Tell beans is the config file
// Commenting ComponentScan will only add components that we manually define.
//@ComponentScan("com.luv2code.springdemo") // Add component scanning support. Scans all classes with @Component.
@PropertySource("classpath:myLogger.properties") // Property source for value injection.
public class AppConfig {
     // Logger Configuration.
    @Bean
    public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                         @Value("${printed.logger.level}") String printedLoggerLevel) {

        return new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);
    }
}
