package com.example.alpha.config;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import javax.servlet.http.HttpServletRequest;

public class CognitoAuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {

    private final OAuth2AuthorizationRequestResolver defaultResolver;
    private final String clientId; // Fixed client ID for Cognito

    public CognitoAuthorizationRequestResolver(ClientRegistrationRepository clientRegistrationRepository, String clientId) {
        this.defaultResolver = new DefaultOAuth2AuthorizationRequestResolver(
                clientRegistrationRepository, "/oauth2/authorize");
        this.clientId = clientId;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        OAuth2AuthorizationRequest authorizationRequest = defaultResolver.resolve(request);

        // Add or modify parameters if needed
        // For example, to add a scope:
        // authorizationRequest = authorizationRequest.withScope("openid profile");

        return authorizationRequest;
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        if (clientId.equals(clientRegistrationId)) {
            return defaultResolver.resolve(request, clientRegistrationId);
        } else {
            return null; // or handle differently based on your requirements
        }
    }
}
