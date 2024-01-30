package com.example.alpha.interceptors;

import com.example.alpha.responses.TokenValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public class RestInterceptor implements HandlerInterceptor {

    private final WebClient webClient;

    public RestInterceptor() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        final String token = request.getHeader("Authorization").replace("Bearer ", "");
        if (!token.isEmpty()) {
            System.out.println("Token Value " + token);
            ObjectMapper objectMapper = new ObjectMapper();
            TokenValidationResponse keycloakResponse = objectMapper.readValue(validateJWT(token), TokenValidationResponse.class);
            System.out.println("Key Cloak Response " + keycloakResponse.getIsActive());
            if(!keycloakResponse.getIsActive()){
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("Access denied");
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    private String validateJWT(String token) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("token", token);
        formData.add("client_id", "alpha");
        formData.add("client_secret", "YebYgmgLuGHd7ZiRuXN5F3iIwr5NuRaw");

        System.out.println("Token validation request " + formData);
        return webClient
                .post()
                .uri("/realms/asgard/protocol/openid-connect/token/introspect")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)  // Set the Content-Type header
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class).block();

    }
}
