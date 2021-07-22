package me.lavecoral.elk.auth.controller;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.api.OauthClientApi;
import me.lavecoral.elk.auth.pojo.dto.OauthClientDto;
import me.lavecoral.elk.auth.service.OauthClientService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lave
 * @date 2021/7/20 00:55
 */
@RestController
@AllArgsConstructor
public class OauthClientController implements OauthClientApi {
    private final OauthClientService oauthClientService;

    @Override
    public OauthClientDto findOne(String clientId) {
        return this.oauthClientService.findByClientId(clientId);
    }
}
