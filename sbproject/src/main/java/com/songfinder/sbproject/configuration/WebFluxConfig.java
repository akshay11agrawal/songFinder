package com.songfinder.sbproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer
{
    @Bean
    @Primary
    public WebClient getWebClient()
    {
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
               // .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
               // .defaultHeader(HttpHeaders.ACCEPT,MediaType.ALL_VALUE)
                .build();
    }
}
