package br.com.smartdelivery.authservice.infrastructure.adapter.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    @Value("${keycloak.server.url}")
    private String keycloakServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client.id}")
    private String clientId;

    @Value("${keycloak.client.secret:}")
    private String clientSecret;

    @Value("${keycloak.admin.username}")
    private String adminUsername;

    @Value("${keycloak.admin.password}")
    private String adminPassword;

    @Bean
    public WebClient keycloakWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(keycloakServerUrl + "/admin/realms/" + realm)
                .defaultHeader("Authorization", "Bearer " + getAdminAccessToken())
                .build();
    }

    private String getAdminAccessToken() {
        WebClient tokenClient = WebClient.create(keycloakServerUrl + "/realms/master/protocol/openid-connect/token");

        String response = tokenClient.post()
                .bodyValue("client_id=" + clientId +
                        (clientSecret.isEmpty() ? "" : "&client_secret=" + clientSecret) +
                        "&username=" + adminUsername +
                        "&password=" + adminPassword +
                        "&grant_type=password")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Extração simples do token do JSON
        return response.replaceAll(".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*", "$1");
    }
}


