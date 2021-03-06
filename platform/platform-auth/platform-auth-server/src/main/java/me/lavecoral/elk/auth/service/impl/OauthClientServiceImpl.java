package me.lavecoral.elk.auth.service.impl;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.model.entity.OauthClient;
import me.lavecoral.elk.auth.pojo.dto.OauthClientDto;
import me.lavecoral.elk.auth.repository.OauthClientRepository;
import me.lavecoral.elk.auth.service.OauthClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author lave
 * @date 2021/7/20 01:01
 */
@Service
@AllArgsConstructor
public class OauthClientServiceImpl implements OauthClientService {
    private final OauthClientRepository oauthClientRepository;

    @Override
    public OauthClientDto findByClientId(String clientId) {
        Optional<OauthClient> applicationOptional = this.oauthClientRepository.findByClientId(clientId);
        return applicationOptional.map(this::toDto).orElse(null);
    }

    private OauthClientDto toDto(OauthClient oauthClient) {
        OauthClientDto oauthClientDto = new OauthClientDto();
        BeanUtils.copyProperties(oauthClient, oauthClientDto);
        return oauthClientDto;
    }
}
