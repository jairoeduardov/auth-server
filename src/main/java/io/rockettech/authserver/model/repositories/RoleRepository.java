package io.rockettech.authserver.model.repositories;

import io.rockettech.authserver.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}