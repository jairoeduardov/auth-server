package io.rockettech.authserver.model.dto;

import java.util.List;

public record CreateAccountDto(
    String username,
    String password,
    List<String> roles){
}
