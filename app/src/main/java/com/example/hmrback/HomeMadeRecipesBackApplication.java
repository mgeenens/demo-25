package com.example.hmrback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hmrback")
public class HomeMadeRecipesBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomeMadeRecipesBackApplication.class, args);
    }
}
