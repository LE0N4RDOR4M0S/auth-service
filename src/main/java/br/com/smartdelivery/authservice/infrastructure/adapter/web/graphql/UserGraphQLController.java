package br.com.smartdelivery.authservice.infrastructure.adapter.web.graphql;

import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/user")
@RequiredArgsConstructor
public class UserGraphQLController {

    private final UserUseCase userUseCase;

    @QueryMapping
    public String hello() {
        return "Hello, GraphQL!";
    }

    @QueryMapping("users")
    public List<UserResponseDTO> users() {
        return userUseCase.getAllUsers();
    }

    @QueryMapping("getUserById")
    public UserResponseDTO getUserById(@Argument String id) {
        return userUseCase.getUserById(id);
    }

    @QueryMapping("getByUsername")
    public UserResponseDTO getByUsername(@Argument String username) {
        return userUseCase.getByUsername(username);
    }

    @QueryMapping("getByEmail")
    public UserResponseDTO getByEmail(@Argument String email) {
        return userUseCase.getByEmail(email);
    }

    @MutationMapping("createUser")
    public UserResponseDTO createUser(@Argument UserRequestDTO input) {
        return userUseCase.createUser(input);
    }

    @MutationMapping("updateUser")
    public UserResponseDTO updateUser(@Argument String id, @Argument UserRequestDTO input){
        return userUseCase.updateUser(id, input);
    }

    @MutationMapping("deleteUser")
    public void deleteUser(@Argument String id) {
        userUseCase.delete(id);
    }
}

