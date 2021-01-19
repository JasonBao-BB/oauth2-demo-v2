package com.example.oauth2serverclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Oauth2ServerClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerClientApplication.class, args);
    }

}
