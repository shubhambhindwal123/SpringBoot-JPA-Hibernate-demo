package com.shubh;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Spring Boot Application Entry Class
 * @author Shubham Bhindwal 
 */
//@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
//@Configuration Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime .
//@Bean is a method-level annotation
@SpringBootApplication 
public class AppDemo {
    final static Logger logger = Logger.getLogger(AppDemo.class);

    /**
     * Main method for
     * 
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Initiating App demo..........");
        SpringApplication.run(AppDemo.class, args);
        logger.info("App demo Started");
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasename("classpath:messages/messages");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }
}
