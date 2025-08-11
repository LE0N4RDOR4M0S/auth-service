package br.com.smartdelivery.authservice.infrastructure.adapter.out.keycloak;

import br.com.smartdelivery.authservice.domain.port.out.RoleKeycloakPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class RoleKeycloakAdapter implements RoleKeycloakPort {

    private final WebClient keycloakWebClient;

    @Override
    public void createRoleInKeycloak(String roleName) {
        keycloakWebClient.post()
                .uri("/roles")
                .bodyValue("{\"name\": \"" + roleName + "\"}")
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void deleteRoleInKeycloak(String roleName) {
        keycloakWebClient.delete()
                .uri("/roles/{roleName}", roleName)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    @Override
    public void updateRoleInKeycloak(String oldName, String newName) {
        deleteRoleInKeycloak(oldName);
        createRoleInKeycloak(newName);
    }
}


