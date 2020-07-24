package com.smartfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class registerApplication {

    public static void main(String[] args) {
        SpringApplication.run(registerApplication.class, args);
    }
}
