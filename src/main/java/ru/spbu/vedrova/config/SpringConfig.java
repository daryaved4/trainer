package ru.spbu.vedrova.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.spbu.vedrova.Application;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class SpringConfig {
}
