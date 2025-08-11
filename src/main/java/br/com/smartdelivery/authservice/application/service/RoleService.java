package br.com.smartdelivery.authservice.application.service;

import br.com.smartdelivery.authservice.domain.dto.request.RoleRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.RoleResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.RoleUseCase;
import br.com.smartdelivery.authservice.domain.port.out.RoleKeycloakPort;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.RoleRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements RoleUseCase {

    private final RoleRepositoryAdapter roleRepository;
    private final RoleKeycloakPort roleKeycloakPort;

    @Override
    @Transactional
    public RoleResponseDTO createRole(RoleRequestDTO role) {
        var savedRole = roleRepository.save(role.toEntity());
        roleKeycloakPort.createRoleInKeycloak(savedRole.getName()); // Sincroniza no Keycloak
        return RoleResponseDTO.toDTO(savedRole);
    }

    @Override
    public RoleResponseDTO getRoleById(String id) {
        return roleRepository.findById(id)
                .map(RoleResponseDTO::toDTO)
                .orElse(null);
    }

    @Override
    public RoleResponseDTO getRoleByName(String name) {
        return roleRepository.findByName(name)
                .map(RoleResponseDTO::toDTO)
                .orElse(null);
    }

    @Override
    @Transactional
    public RoleResponseDTO updateRole(String id, RoleRequestDTO role) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setName(role.getName());
                    var updated = roleRepository.save(existingRole);
                    roleKeycloakPort.updateRoleInKeycloak(existingRole.getName(),updated.getName());
                    return RoleResponseDTO.toDTO(updated);
                })
                .orElse(null);
    }

    @Override
    @Transactional
    public void deleteRole(String id) {
        roleRepository.findById(id).ifPresent(role -> {
            roleRepository.deleteById(id);
            roleKeycloakPort.deleteRoleInKeycloak(role.getName());
        });
    }

    @Override
    public boolean roleExists(String name) {
        return roleRepository.existsByName(name);
    }

    @Override
    public List<RoleResponseDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(RoleResponseDTO::toDTO)
                .toList();
    }
}
