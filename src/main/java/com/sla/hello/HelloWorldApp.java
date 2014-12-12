package com.sla.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class HelloWorldApp extends SpringBootServletInitializer {

    // Used when deploying to a standalone servlet container
    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext ctx = SpringApplication.run(HelloWorldApp.class, args);

    }


    // Used when deploying to a standalone servlet container
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(HelloWorldApp.class);
    }


    @Bean
    public ServletContextTemplateResolver templateResolver() {

        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();

        System.out.println("blah!**************************************************");
        resolver.setPrefix("/resources/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);

        return resolver;
    }

}
