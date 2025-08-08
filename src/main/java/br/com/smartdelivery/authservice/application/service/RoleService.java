package br.com.smartdelivery.authservice.application.service;

import br.com.smartdelivery.authservice.domain.dto.request.RoleRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.RoleResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.RoleUseCase;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.RoleRepositoryAdapter;

public class RoleService implements RoleUseCase {

    private final RoleRepositoryAdapter roleRepository;

    public RoleService(RoleRepositoryAdapter roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO role) {
        return RoleResponseDTO.toDTO(roleRepository.save(role.toEntity()));
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
    public RoleResponseDTO updateRole(String id, RoleRequestDTO role) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setName(role.getName());
                    return RoleResponseDTO.toDTO(roleRepository.save(existingRole));
                })
                .orElse(null);
    }

    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public boolean roleExists(String name) {
        return roleRepository.existsByName(name);
    }
}
