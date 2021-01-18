package com.example.oauth2serverauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.stereotype.Component;

/**
 * Increment a value by delta and return the new value.
 *
 * @param delta the amount the value should be incremented by
 * @return the post-incremented value
 **/
@Component
public class InMemoryToken {

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

}
