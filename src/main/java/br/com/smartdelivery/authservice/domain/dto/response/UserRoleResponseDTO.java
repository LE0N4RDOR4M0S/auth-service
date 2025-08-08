package br.com.smartdelivery.authservice.domain.dto.response;

public class UserRoleResponseDTO {
    private String userId;
    private String roleId;

    public UserRoleResponseDTO() {
    }

    public UserRoleResponseDTO(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
