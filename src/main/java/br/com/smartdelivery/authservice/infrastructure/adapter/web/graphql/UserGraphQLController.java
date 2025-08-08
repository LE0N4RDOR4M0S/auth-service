package br.com.smartdelivery.authservice.infrastructure.adapter.web.graphql;

import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

    private final UserUseCase userUseCase;

    @QueryMapping
    public List<UserResponseDTO> users() {
        return userUseCase.getAllUsers();
    }

    @MutationMapping
    public UserResponseDTO createUser(@Argument UserRequestDTO input) {
        return userUseCase.createUser(input);
    }
}

