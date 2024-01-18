package io.rockettech.authserver.model.services;

import io.rockettech.authserver.model.dto.CreateAccountDto;
import io.rockettech.authserver.model.dto.MessageDto;

public interface AccountService {
    public MessageDto createUser(CreateAccountDto dto);
}
