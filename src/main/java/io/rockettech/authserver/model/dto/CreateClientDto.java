package io.rockettech.authserver.model.dto;


import lombok.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class CreateClientDto {
    private String clientId;
    private String clientSecret;
    private Set<ClientAuthenticationMethod> authenticationMethods;
    private Set<AuthorizationGrantType> authorizationGrantTypes;
    private Set<String> redirectUris;
    private Set<String> scopes;
    private boolean requireProofKey;
    private Set<String> postLogoutRedirectUri;
}
