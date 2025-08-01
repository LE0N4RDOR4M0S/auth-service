package br.com.smartdelivery.authservice.infrastructure.adapter.persistence.mapper;

import br.com.smartdelivery.authservice.domain.JpaRoleEntity;
import br.com.smartdelivery.authservice.domain.model.Role;

public class RoleMapper {
    public static Role toDomain(JpaRoleEntity entity){
        return new Role(
                entity.getId(),
                entity.getName()
        );
    }

    public static JpaRoleEntity toEntity(Role role){
        return new JpaRoleEntity(
                role.getId(),
                role.getName()
        );
    }
}
