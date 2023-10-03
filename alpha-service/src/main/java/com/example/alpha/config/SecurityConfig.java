package com.example.alpha.config;

import com.example.alpha.services.CustomOidcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

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
                                .anyRequest().authenticated())
                .oauth2Login(oauth2Login ->
                                oauth2Login
                                        .loginPage("https://cog-sandbox.auth.ap-south-1.amazoncognito.com/login?client_id=" + cognitoConfig.getClientId())
                                        .defaultSuccessUrl("/success")
                                        .authorizationEndpoint(authorizationEndpoint ->
                                                        authorizationEndpoint
                                                                .baseUri(cognitoConfig.getAuthorizationUri())
                                                                .authorizationRequestResolver(new CognitoAuthorizationRequestResolver(clientRegistrationRepository(),cognitoConfig.getClientId()))
                                        )
                                                        .userInfoEndpoint(userInfoEndpoint ->
                                                        userInfoEndpoint.oidcUserService(oidcUserService()))
                                        )
                .cors();
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration registration = ClientRegistration
                .withRegistrationId("cognito")
                .clientId(cognitoConfig.getClientId())
                .redirectUri("http:/localhost:8080/login/oauth2/code/cognito")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .scope("openid", "phone", "email")
                .authorizationUri(cognitoConfig.getAuthorizationUri())
                .tokenUri(cognitoConfig.getTokenUri())
                .jwkSetUri(cognitoConfig.getJwkSetUri())
                .clientName("microservice-sandbox")
                .build();

        return new InMemoryClientRegistrationRepository(registration);
    }

    @Bean
    public CustomOidcUserService oidcUserService() {
        return new CustomOidcUserService();
    }

}
