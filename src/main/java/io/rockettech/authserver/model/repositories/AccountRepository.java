package io.rockettech.authserver.model.repositories;

import io.rockettech.authserver.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Optional<Account> findByUuid(String uuid);

}