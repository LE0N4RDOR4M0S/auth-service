package br.com.smartdelivery.authservice.domain.port.out;

import br.com.smartdelivery.authservice.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);

    Optional<User> findAll();

    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void deleteById(UUID id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
