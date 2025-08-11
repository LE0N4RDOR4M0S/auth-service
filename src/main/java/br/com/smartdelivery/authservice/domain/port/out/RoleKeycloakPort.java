package br.com.smartdelivery.authservice.domain.port.out;

public interface RoleKeycloakPort {
    void createRoleInKeycloak(String roleName);
    void updateRoleInKeycloak(String roleName, String newName);
    void deleteRoleInKeycloak(String roleName);
}

