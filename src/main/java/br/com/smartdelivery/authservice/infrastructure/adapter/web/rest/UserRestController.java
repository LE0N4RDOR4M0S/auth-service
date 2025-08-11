package br.com.smartdelivery.authservice.infrastructure.adapter.web.rest;


import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "")
public class UserRestController {
    private final UserUseCase service;

    @GetMapping
    @Operation(
            summary = "Listar todos os usuários",
            description = "Retorna todos os usuários cadastrados no sistema"
    )
    private List<UserResponseDTO> getAll(){
        return service.getAllUsers();
    }
    
    @PostMapping
    @Operation(
            summary = "Criar um novo usuário",
            description = "Cria um novo usuário e retorna um response"
    )
    private UserResponseDTO create(@RequestBody UserRequestDTO input){
        return service.createUser(input);
    }
    
    @GetMapping("/{id}")
    @Operation(
            summary = "Busca um usuário pelo Id",
            description = "Retorna o usuário com o id respectivo"
    )
    private UserResponseDTO getById(@PathVariable String id){
        return service.getUserById(id);
    }
    
    @GetMapping("/name/{input}")
    private UserResponseDTO getByName(@PathVariable String input){
        return service.getByUsername(input);
    }

    @GetMapping("/email/{input}")
    private UserResponseDTO getByEmail(@PathVariable String input){
        return service.getByEmail(input);
    }

    @PutMapping("/{id}")
    private UserResponseDTO update(@RequestBody UserRequestDTO input, @PathVariable String id){
        return service.updateUser(id, input);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable String id){
        service.delete(id);
    }
}
