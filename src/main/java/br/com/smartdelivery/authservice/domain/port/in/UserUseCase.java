package br.com.smartdelivery.authservice.domain.port.in;

import br.com.smartdelivery.authservice.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {
    User createUser(User user);
    Optional<User> getUserById(UUID id);
    Optional<User> getByUsername(String username);
}
