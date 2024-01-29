package io.rockettech.authserver.model.services.impls;

import io.rockettech.authserver.model.dto.AccountDto;
import io.rockettech.authserver.model.dto.CreateAccountDto;
import io.rockettech.authserver.model.dto.MessageDto;
import io.rockettech.authserver.model.entities.Account;
import io.rockettech.authserver.model.entities.Role;
import io.rockettech.authserver.model.enums.RoleName;
import io.rockettech.authserver.model.repositories.AccountRepository;
import io.rockettech.authserver.model.repositories.RoleRepository;
import io.rockettech.authserver.model.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public MessageDto createUser(CreateAccountDto dto){
        Account account = Account.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
        Set<Role> roles = new HashSet<>();
        dto.roles().forEach( r -> {
            Role role = roleRepository.findByRole(RoleName.valueOf(r)).orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role);
        });

        account.setRoles(roles);
        accountRepository.save(account);
        return new MessageDto("User " + account.getUsername() + "saved");
    }

    @Override
    public AccountDto updateAccount(AccountDto dto, String uuid) {
                accountRepository.findByUuid(uuid)
                        .map(entity -> {
                            modelMapper.map(dto, entity);
                            System.out.println(entity);
                            return accountRepository.save(entity);
                        })
                        .orElseThrow(() -> new EntityNotFoundException("Account not found UUID:" + uuid));
        return null;
    }

    @Override
    public AccountDto findByUuid(String uuid) {
        return accountRepository.findByUuid(uuid)
                .map( entity -> modelMapper.map(entity, AccountDto.class) )
                .orElseThrow(() -> new EntityNotFoundException("Account not found UUID: " + uuid));
    }

}
