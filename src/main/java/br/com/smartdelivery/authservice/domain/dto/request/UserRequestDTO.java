package br.com.smartdelivery.authservice.domain.dto.request;

import br.com.smartdelivery.authservice.domain.model.Role;
import br.com.smartdelivery.authservice.domain.model.User;

import java.util.Set;

public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String email, String password, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRoles(this.roles);
        return user;
    }
}
