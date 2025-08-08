package br.com.smartdelivery.authservice.domain.port.out;

import br.com.smartdelivery.authservice.domain.model.Role;
import br.com.smartdelivery.authservice.domain.model.UserRole;
import graphql.org.antlr.v4.runtime.misc.MultiMap;

import java.util.List;
import java.util.Optional;

public interface RoleRepositoryPort {
    Role save(Role role);
    Optional<Role> findById(String id);
    List<Role> findAll();
    boolean existsByName(String name);
    Optional<Role> findByName(String name);
    List<Role> findByUserId(String userId);
    void deleteById(String id);
}
