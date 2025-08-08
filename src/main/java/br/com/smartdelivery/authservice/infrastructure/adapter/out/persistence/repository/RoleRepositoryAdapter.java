package br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository;

import br.com.smartdelivery.authservice.domain.model.Role;
import br.com.smartdelivery.authservice.domain.port.out.RoleRepositoryPort;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.mapper.RoleMapper;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.spring.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepositoryPort {

    private final JpaRoleRepository jpaRoleRepository;

    @Override
    public Role save(Role role) {
        return RoleMapper.toDomain(
                jpaRoleRepository.save(RoleMapper.toEntity(role))
        );
    }

    @Override
    public Optional<Role> findById(String id) {
        return jpaRoleRepository.findById(UUID.fromString(id))
                .map(RoleMapper::toDomain);
    }

    @Override
    public List<Role> findAll() {
        return jpaRoleRepository.findAll()
                .stream()
                .map(RoleMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRoleRepository.findByName(name).isPresent();
    }

    @Override
    public Optional<Role> findByName(String name) {
        return jpaRoleRepository.findByName(name);
    }

    @Override
    public List<Role> findByUserId(String userId) {
        return List.of();
    }

    @Override
    public void deleteById(String id) {
        jpaRoleRepository.deleteById(UUID.fromString(id));
    }
}
