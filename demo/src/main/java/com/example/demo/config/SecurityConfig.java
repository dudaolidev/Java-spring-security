package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/index", "/logado").authenticated() // deve ser autenticado
                .antMatchers("/deslogado").permitAll() // não precisa ser autenticado
                .anyRequest().authenticated()
                .and()
                .oauth2Login().permitAll()
                // liberar enpoint de login
                .and()
                .logout()
                .invalidateHttpSession(true) // enpoint de login = publica, para que as pessoas possam se autenticar de fato
                .clearAuthentication(true)
                .logoutSuccessUrl("/");

    }
}
