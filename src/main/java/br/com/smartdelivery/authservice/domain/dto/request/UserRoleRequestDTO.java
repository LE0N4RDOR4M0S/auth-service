package br.com.smartdelivery.authservice.domain.dto.request;

public class UserRoleRequestDTO {
    private String userId;
    private String roleId;

    public UserRoleRequestDTO() {
    }

    public UserRoleRequestDTO(String userId, String roleId) {
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
