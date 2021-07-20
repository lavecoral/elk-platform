package me.lavecoral.elk.auth.service;

import me.lavecoral.elk.auth.pojo.dto.OauthClientDto;

/**
 * @author lave
 * @date 2021/7/20 00:57
 */
public interface OauthClientService {

    OauthClientDto findByClientId(String clientId);
}
