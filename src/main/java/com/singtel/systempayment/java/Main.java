package com.singtel.systempayment.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource ms) {

        LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
        lvfb.setValidationMessageSource(ms);

        return lvfb;

    }

}