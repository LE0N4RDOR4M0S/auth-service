package br.com.smartdelivery.authservice.infrastructure.adapter.web.rest;

import br.com.smartdelivery.authservice.domain.dto.request.RoleRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.RoleResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.RoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/role")
@RequiredArgsConstructor
public class RoleRestController {
    private final RoleUseCase service;

    @GetMapping
    private List<RoleResponseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    private RoleResponseDTO getById(String id) {
        return service.getRoleById(id);
    }

    @GetMapping("/name/{name}")
    private RoleResponseDTO getByName(String name) {
        return service.getRoleByName(name);
    }

    @GetMapping("/exists/{name}")
    private boolean roleExists(String name) {
        return service.roleExists(name);
    }

    @GetMapping("/create/{name}")
    private RoleResponseDTO createRole(String name) {
        return service.createRole(new RoleRequestDTO(name));
    }

    @GetMapping("/update/{id}/{name}")
    private RoleResponseDTO updateRole(String id, String name) {
        return service.updateRole(id, new RoleRequestDTO(name));
    }

    @GetMapping("/delete/{id}")
    private void deleteRole(String id) {
        service.deleteRole(id);
    }
}
