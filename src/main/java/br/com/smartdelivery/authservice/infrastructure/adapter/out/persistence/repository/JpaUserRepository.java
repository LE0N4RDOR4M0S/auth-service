package br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
