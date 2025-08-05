package br.com.smartdelivery.authservice.domain.port.out;

import br.com.smartdelivery.authservice.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
        User save(User user);
        Optional<User> findById(UUID id);
}
