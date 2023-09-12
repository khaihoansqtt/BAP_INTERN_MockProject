package com.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.OPTIONS;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.
                addMapping("/**").
                allowedOrigins("*").
                allowedMethods(GET.name(), POST.name(), PUT.name(), DELETE.name(), OPTIONS.name()).
                allowedHeaders("Authorization", "Content-Type", "Accept-Language").
                allowCredentials(true);
    }
}
