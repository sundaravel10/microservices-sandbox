package com.example.alpha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CognitoConfig cognitoConfig;

    @Autowired
    public SecurityConfig(CognitoConfig cognitoConfig) {
        this.cognitoConfig = cognitoConfig;
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/api/beta/getStatus").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessUrl("/");
        return http.build();
    }

}
