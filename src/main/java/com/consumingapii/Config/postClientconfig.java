package com.consumingapii.Config;


import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class postClientconfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(
            @Value("${post-service.username}") String username,
            @Value("${post-service.password}") String password) {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
