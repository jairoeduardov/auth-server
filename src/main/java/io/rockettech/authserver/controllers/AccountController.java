package io.rockettech.authserver.controllers;

import io.rockettech.authserver.model.dto.AccountDto;
import io.rockettech.authserver.model.entities.Account;
import io.rockettech.authserver.model.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-server/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/{uuid}")
    public ResponseEntity<AccountDto> findByUuid(@PathVariable String uuid, Authentication authentication){
        return ResponseEntity.ok(accountService.findByUuid(uuid));
    }

}
