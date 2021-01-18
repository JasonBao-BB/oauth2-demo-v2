package com.example.oauth2serverauthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /*
    * Password Encoder
    * */
    @Autowired
    @Qualifier("BCrypt")
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private TokenStore tokenStore;
//
//    @Autowired
//    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationServerTokenServices tokenServices;

    @Autowired
    @Qualifier("JWTService")
    private AuthorizationServerTokenServices jwtServices;


    /*
    * 它的安全指的是对于OAuth2 本来身来说
    * 适当的进行暴露
    * */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()") // /oauth/token_key
                .checkTokenAccess("permitAll()") // /oauth/check_token
                .allowFormAuthenticationForClients();
    }
    /*
    * EndPoints - 端点
    * Endpoint是用来配置Token
    * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenServices(jwtServices);
    }
    /*
    * Clients - 用来配置客户端
    * OAuth2 - 哪些客户端可以被授权访问
    * ExcelReporting -> client: excel
    * PDFReporting -> client: pdf
    * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("c1") //设置客户端ID
                .secret(passwordEncoder.encode("secret")) //设置客户端的秘钥
                .authorizedGrantTypes("authorization_code","refresh_token")
                .scopes("all")
                .resourceIds("weapon")
                .autoApprove(false)
                .redirectUris("http://www.bilibili.com");

    }
}
