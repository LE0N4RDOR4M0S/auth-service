package br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.User;
import br.com.smartdelivery.authservice.domain.port.out.UserRepositoryPort;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.mapper.UserMapper;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.spring.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        return UserMapper.toDomain(
                jpaUserRepository.save(UserMapper.toEntity(user))
        );
    }

    @Override
    public Optional<User> findAll() {
        return jpaUserRepository.findAll()
                .stream()
                .map(UserMapper::toDomain)
                .findFirst();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaUserRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByName(username)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpaUserRepository.existsByName(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
