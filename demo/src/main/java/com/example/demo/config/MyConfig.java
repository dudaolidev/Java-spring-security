package com.example.demo.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index"); // nome html
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/logado").setViewName("logado");
        registry.addViewController("/deslogado").setViewName("deslogado");
    }
}
