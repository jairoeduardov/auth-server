package io.rockettech.authserver.model.services;

import io.rockettech.authserver.model.dto.AccountDto;
import io.rockettech.authserver.model.dto.CreateAccountDto;
import io.rockettech.authserver.model.dto.MessageDto;

public interface AccountService {
    public MessageDto createUser(CreateAccountDto dto);
    public AccountDto updateAccount(AccountDto dto, String uuid);
    public AccountDto findByUuid(String uuid);

}
