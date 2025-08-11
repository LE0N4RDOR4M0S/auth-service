package br.com.smartdelivery.authservice.domain.port.in;

import br.com.smartdelivery.authservice.domain.dto.request.RoleRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.RoleResponseDTO;

import java.util.List;

public interface RoleUseCase {
    RoleResponseDTO createRole(RoleRequestDTO role);
    RoleResponseDTO getRoleById(String id);
    RoleResponseDTO getRoleByName(String name);
    RoleResponseDTO updateRole(String id, RoleRequestDTO role);
    void deleteRole(String id);
    boolean roleExists(String name);

    List<RoleResponseDTO> getAll();
}
