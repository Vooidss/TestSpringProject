package ru.organization.spring.Task_1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.organization.spring")
@PropertySource("classpath:PlayerMusic.properties")
public class SpringConfig {
}