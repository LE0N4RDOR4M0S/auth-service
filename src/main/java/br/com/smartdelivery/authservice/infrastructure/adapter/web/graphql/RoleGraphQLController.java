package br.com.smartdelivery.authservice.infrastructure.adapter.web.graphql;

import br.com.smartdelivery.authservice.domain.dto.request.RoleRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.RoleResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.RoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/role")
@RequiredArgsConstructor
public class RoleGraphQLController {
    private final RoleUseCase roleUseCase;

    @QueryMapping(name = "getAllRoles")
    public List<RoleResponseDTO> getAllRoles() {
        return roleUseCase.getAll();
    }

    @QueryMapping(name = "getRoleById")
    public RoleResponseDTO getRoleById(@Argument String id) {
        return roleUseCase.getRoleById(id);
    }

    @QueryMapping(name = "getRoleByName")
    public RoleResponseDTO getRoleByName(@Argument String name) {
        return roleUseCase.getRoleByName(name);
    }

    @QueryMapping(name = "roleExists")
    public boolean roleExists(@Argument String name) {
        return roleUseCase.roleExists(name);
    }

    @MutationMapping(name = "createRole")
    public RoleResponseDTO createRole(@Argument RoleRequestDTO role) {
        return roleUseCase.createRole(role);
    }

    @MutationMapping(name = "updateRole")
    public RoleResponseDTO updateRole(@Argument String id, @Argument RoleRequestDTO role) {
        return roleUseCase.updateRole(id, role);
    }

    @MutationMapping(name = "deleteRole")
    public void deleteRole(@Argument String id) {
        roleUseCase.deleteRole(id);
    }

}
