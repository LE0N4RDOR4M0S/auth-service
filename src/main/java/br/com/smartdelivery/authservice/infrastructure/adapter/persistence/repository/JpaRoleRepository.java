package br.com.smartdelivery.authservice.infrastructure.adapter.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaRoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
