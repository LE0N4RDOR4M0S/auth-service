package br.com.smartdelivery.authservice.domain.dto.response;

import br.com.smartdelivery.authservice.domain.model.Role;

public class RoleResponseDTO {
    private String id;
    private String name;

    public RoleResponseDTO() {
    }

    public RoleResponseDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static RoleResponseDTO toDTO(Role role) {
        if (role == null) {
            return null;
        }
        return new RoleResponseDTO(role.getId().toString(), role.getName());
    }
}
