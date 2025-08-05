package br.com.smartdelivery.authservice.application.service;

import br.com.smartdelivery.authservice.domain.model.User;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import br.com.smartdelivery.authservice.domain.port.out.UserRepository;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.mapper.UserMapper;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {
    private final JpaUserRepository userRepository;

    @Override
    public User createUser(User user) {
        return UserMapper.toDomain(userRepository.save(UserMapper.toEntity(user)));
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByName(username).map(UserMapper::toDomain);
    }
}
