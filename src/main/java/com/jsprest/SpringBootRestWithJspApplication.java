package com.jsprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootRestWithJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestWithJspApplication.class, args);
    }

}
