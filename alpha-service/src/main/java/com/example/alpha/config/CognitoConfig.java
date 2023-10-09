package com.example.alpha.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cognito")
@Data
public class CognitoConfig {

    private String userPoolId;
    private String clientId;
    private String authorizationUri;
    private String tokenUri;
    private String jwkSetUri;
    private String redirectionUri;

}

