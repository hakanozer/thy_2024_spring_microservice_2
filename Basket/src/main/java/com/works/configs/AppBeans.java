package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
public class AppBeans {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
    @Bean
    public RestTemplate restTemplate1() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(null);
        return restTemplate;
    }

    @Bean
    public Random random(RestTemplate restTemplate) {
        return new Random();
    }
     */

}
