package br.com.smartdelivery.authservice.domain.dto.request;

import br.com.smartdelivery.authservice.domain.model.Role;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.entity.JpaRoleEntity;

public class RoleRequestDTO {
    private String name;

    public RoleRequestDTO() {}

    public RoleRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role toEntity(){
        Role role = new Role();
        role.setName(this.name);
        return role;
    }
}
