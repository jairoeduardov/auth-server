package io.rockettech.authserver.model.services.impls;

import io.rockettech.authserver.model.entities.Account;
import io.rockettech.authserver.model.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    //@Autowired
    private final AccountRepository accountRepository;

    //@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username) .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }


}