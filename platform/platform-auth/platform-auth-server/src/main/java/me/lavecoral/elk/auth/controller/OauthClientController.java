package me.lavecoral.elk.auth.controller;

import me.lavecoral.elk.auth.pojo.dto.OauthClientDto;
import me.lavecoral.elk.auth.service.OauthClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lave
 * @date 2021/7/20 00:55
 */
@RestController
@RequestMapping("/api/v1/oauth/client")
public class OauthClientController {
    private final OauthClientService oauthClientService;

    public OauthClientController(OauthClientService oauthClientService) {
        this.oauthClientService = oauthClientService;
    }

    @GetMapping("/{applicationId}")
    public OauthClientDto findOne(@PathVariable String applicationId) {
        return this.oauthClientService.findByClientId(applicationId);
    }
}


/*
@Api(tags = "客户端接口")
@RestController
@RequestMapping("/api/v1/oauth-clients")
@Slf4j
@AllArgsConstructor
 */
