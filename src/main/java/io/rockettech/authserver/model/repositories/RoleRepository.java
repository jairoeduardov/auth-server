package io.rockettech.authserver.model.repositories;

import io.rockettech.authserver.model.entities.Role;
import io.rockettech.authserver.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleName roleName);
}