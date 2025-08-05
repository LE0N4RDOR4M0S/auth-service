package br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.User;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.entity.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {
    Optional<JpaUserEntity> findByEmail(String email);
    Optional<JpaUserEntity> findByName(String username);
}
