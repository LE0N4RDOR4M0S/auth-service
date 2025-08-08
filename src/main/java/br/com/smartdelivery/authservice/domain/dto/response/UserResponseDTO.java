package br.com.smartdelivery.authservice.domain.dto.response;

import br.com.smartdelivery.authservice.domain.model.User;

public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String createdAt;
    private String updatedAt;
    private RoleResponseDTO role;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String id, String name, String email, String createdAt, String updatedAt, RoleResponseDTO role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public RoleResponseDTO getRole() {
        return role;
    }

    public void setRole(RoleResponseDTO role) {
        this.role = role;
    }

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId().toString());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setCreatedAt(user.getCreatedAt().toString());
        userResponseDTO.setUpdatedAt(user.getUpdatedAt().toString());

        if (!user.getRoles().isEmpty()){
            RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
            roleResponseDTO.setId(user.getRoles().iterator().next().getId().toString());
            roleResponseDTO.setName(user.getRoles().iterator().next().getName());
            userResponseDTO.setRole(roleResponseDTO);
        } else {
            userResponseDTO.setRole(null);
        }

        return userResponseDTO;
    }
}
