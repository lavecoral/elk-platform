package me.lavecoral.elk.auth.security.service;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.model.enums.PasswordEncoderTypeEnum;
import me.lavecoral.elk.auth.repository.OauthClientRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @author lave
 * @date 2021/7/22 22:20
 */
@Service
@AllArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private final OauthClientRepository oauthClientRepository;

    /**
     * Load a client by the client id. This method must not return null.
     *
     * @param clientId The client id.
     * @return The client details (never null).
     * @throws ClientRegistrationException If the client account is locked, expired, disabled, or invalid for any other reason.
     */
    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        if (StringUtils.isBlank(clientId)) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        return oauthClientRepository.findByClientId(clientId).map(client -> {
            BaseClientDetails clientDetails = new BaseClientDetails(
                    client.getClientId(),
                    client.getResourceIds(),
                    client.getScope(),
                    client.getAuthorizedGrantTypes(),
                    client.getAuthorities(),
                    client.getWebServerRedirectUri()
            );
            clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
            return clientDetails;
        }).orElseThrow(() -> new NoSuchClientException("No client with requested id: " + clientId));

    }
}
