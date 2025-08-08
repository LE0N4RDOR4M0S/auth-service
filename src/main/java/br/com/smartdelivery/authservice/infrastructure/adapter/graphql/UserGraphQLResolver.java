package br.com.smartdelivery.authservice.infrastructure.adapter.graphql;

import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.model.User;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

@Component
public class UserGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final UserUseCase userUseCase;

    public UserGraphQLResolver(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    public UserResponseDTO getUserById(String id) {
        return userUseCase.getUserById(id);
    }

    public UserResponseDTO createUser(String username, String email, String password) {
        UserRequestDTO user = new UserRequestDTO(username, email, password, new HashSet<>());
        return userUseCase.createUser(user);
    }
}
