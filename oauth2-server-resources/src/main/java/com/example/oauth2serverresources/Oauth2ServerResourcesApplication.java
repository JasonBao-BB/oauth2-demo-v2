package com.example.oauth2serverresources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Oauth2ServerResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerResourcesApplication.class, args);
    }

}
