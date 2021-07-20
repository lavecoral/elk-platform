package me.lavecoral.elk.auth.api;

import me.lavecoral.elk.auth.pojo.dto.OauthClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lave
 * @date 2021/7/20 00:46
 */
@RequestMapping("/api/v1/oauth/client")
@FeignClient(value = "application", contextId = "auth-application")
public interface OauthClientApi {

    /**
     * 根据OAuth Client Id获取Client信息
     *
     * @param clientId Client ID
     * @return Client 信息
     */
    @GetMapping("/{clientId}")
    OauthClientDto findOne(@PathVariable String clientId);
}
