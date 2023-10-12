package com.ms.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi emailApi() {
        return GroupedOpenApi.builder()
                .group("email-controller")
                .pathsToMatch("/**")
                .build();
    }

}