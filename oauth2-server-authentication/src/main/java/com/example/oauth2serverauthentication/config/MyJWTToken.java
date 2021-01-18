package com.example.oauth2serverauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;


@Component
public class MyJWTToken {

    @Autowired
    @Qualifier("JWTConverter")
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    private String SINGING_KEY = "himawari2020";

    @Bean(name = "JWT")
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean(name = "JWTConverter")
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SINGING_KEY);
        return converter;
    }
}
