package com.systemdesign.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  // ✅ Enables caching across the app
public class SystemDesignDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemDesignDemoApplication.class, args);
    }
}
