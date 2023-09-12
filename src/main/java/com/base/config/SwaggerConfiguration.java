package com.base.config;

import com.base.config.prop.SwaggerProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private SwaggerProperties swaggerProperties;

    private AuthorizationScope read = new AuthorizationScope("read", "read all");
    private AuthorizationScope write = new AuthorizationScope("write", "write all");
    private AuthorizationScope trust = new AuthorizationScope("trust", "trust all");

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{read, write, trust};
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.base.controller")).
                paths(PathSelectors.any()).
                build().
                securityContexts(Arrays.asList(securityContext())).
                securitySchemes(Arrays.asList(apiKey())).
                apiInfo(apiInfo());
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer", HttpHeaders.AUTHORIZATION, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().
                securityReferences(Arrays.asList(new SecurityReference("Bearer", scopes()))).
                forPaths(PathSelectors.ant("/api/**")).
                build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title(swaggerProperties.getTitle()).
                description(swaggerProperties.getDescription()).
                version(swaggerProperties.getVersion()).
                build();
    }
}
