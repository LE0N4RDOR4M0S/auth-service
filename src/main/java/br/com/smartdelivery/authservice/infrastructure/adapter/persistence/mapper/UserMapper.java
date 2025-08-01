package br.com.smartdelivery.authservice.infrastructure.adapter.persistence.mapper;

import br.com.smartdelivery.authservice.domain.JpaUserEntity;
import br.com.smartdelivery.authservice.domain.model.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static User toDomain(JpaUserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getRoles().stream().map(RoleMapper::toDomain).collect(Collectors.toSet())
        );
    }

    public static JpaUserEntity toEntity(User user) {
        return new JpaUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getRoles().stream().map(RoleMapper::toEntity).collect(Collectors.toSet())
        );
    }
}
