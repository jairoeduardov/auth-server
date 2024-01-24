package io.rockettech.authserver.model.services.impls;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.rockettech.authserver.model.dto.CreateClientDto;
import io.rockettech.authserver.model.dto.MessageDto;
import io.rockettech.authserver.model.entities.Client;
import io.rockettech.authserver.model.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.jackson2.OAuth2AuthorizationServerJackson2Module;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService implements RegisteredClientRepository {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        Client client = clientRepository.findByClientId(id)
                .orElseThrow(()-> new RuntimeException("client not found"));
        return Client.toRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = clientRepository.findByClientId(clientId)
                .orElseThrow(()-> new RuntimeException("client not found"));
        return Client.toRegisteredClient(client);
    }

    public MessageDto create(CreateClientDto dto){
        Client client = clientFromDto(dto);
        clientRepository.save(client);
        return new MessageDto("client " + client.getClientId() + " saved");
    }

    // private methods
    private Client clientFromDto(CreateClientDto dto){
        Client client = Client.builder()
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .authenticationMethods(dto.getAuthenticationMethods())
                .authorizationGrantTypes(dto.getAuthorizationGrantTypes())
                .redirectUris(dto.getRedirectUris())
                .scopes(dto.getScopes())
                .requireProofKey(dto.isRequireProofKey())
                .postLogoutRedirectUri(dto.getPostLogoutRedirectUri())
                .build();
        return client;
    }

}
