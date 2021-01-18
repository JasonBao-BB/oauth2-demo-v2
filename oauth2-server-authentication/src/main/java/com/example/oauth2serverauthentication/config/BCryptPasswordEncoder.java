package com.example.oauth2serverauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Component
public class BCryptPasswordEncoder {
    @Bean(name = "BCrypt")
    public PasswordEncoder passwordEncoder(){
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
