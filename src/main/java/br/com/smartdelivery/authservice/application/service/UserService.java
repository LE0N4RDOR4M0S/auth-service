package br.com.smartdelivery.authservice.application.service;

import br.com.smartdelivery.authservice.domain.dto.request.UserRequestDTO;
import br.com.smartdelivery.authservice.domain.dto.response.UserResponseDTO;
import br.com.smartdelivery.authservice.domain.port.in.UserUseCase;
import br.com.smartdelivery.authservice.infrastructure.adapter.out.persistence.repository.UserRepositoryAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserUseCase {
    private final UserRepositoryAdapter userRepository;

    public UserService(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO user) {
        return UserResponseDTO.toDTO(userRepository.save(user.toEntity()));
    }

    @Override
    public UserResponseDTO getUserById(String id) {
        return userRepository.findById(UUID.fromString(id)).map(UserResponseDTO::toDTO).orElse(null);
    }

    @Override
    public UserResponseDTO getByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserResponseDTO::toDTO)
                .orElse(null);
    }

    @Override
    public UserResponseDTO getByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserResponseDTO::toDTO)
                .orElse(null);
    }

    @Override
    public UserResponseDTO updateUser(String id, UserRequestDTO user) {
        return userRepository.findById(UUID.fromString(id))
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return UserResponseDTO.toDTO(userRepository.save(existingUser));
                })
                .orElse(null);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDTO::toDTO)
                .collect(Collectors.toList());
    }
}
