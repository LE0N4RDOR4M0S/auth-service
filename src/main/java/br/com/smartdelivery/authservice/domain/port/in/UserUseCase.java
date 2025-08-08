package br.com.smartdelivery.authservice.domain.port.in;

import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO getUserById(String id);
    UserResponseDTO getByUsername(String username);
    UserResponseDTO getByEmail(String email);
    UserResponseDTO updateUser(String id, UserRequestDTO user);
    List<UserResponseDTO> getAllUsers();
}
