package com.example.oauth2serverclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    @Qualifier("JWT")
    private TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("weapon")
                .tokenStore(tokenStore)
                .stateless(true);
    }

//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setClientSecret("secret");
//        tokenServices.setClientId("c1");
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//        return tokenServices;
//    }

}
