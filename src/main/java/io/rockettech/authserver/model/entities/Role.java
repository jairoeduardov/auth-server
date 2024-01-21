package io.rockettech.authserver.model.entities;

import io.rockettech.authserver.model.enums.RoleName;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    @Override
    public String getAuthority() {
        return role.name();
    }
}