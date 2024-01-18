package io.rockettech.authserver.controllers;

import io.rockettech.authserver.model.dto.CreateAccountDto;
import io.rockettech.authserver.model.dto.MessageDto;
import io.rockettech.authserver.model.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@RequestBody CreateAccountDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createUser(dto));
    }
}
