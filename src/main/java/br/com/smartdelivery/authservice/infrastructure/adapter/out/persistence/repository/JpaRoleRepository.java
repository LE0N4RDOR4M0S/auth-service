package br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.Role;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.entity.JpaRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaRoleRepository extends JpaRepository<JpaRoleEntity, UUID> {
    Optional<Role> findByName(String name);
}
