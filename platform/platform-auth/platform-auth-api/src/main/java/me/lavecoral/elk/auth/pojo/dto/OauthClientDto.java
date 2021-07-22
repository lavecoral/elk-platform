package me.lavecoral.elk.auth.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lave
 * @date 2021/7/20 00:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthClientDto implements Serializable {
    private static final long serialVersionUID = -8702579527820763463L;
    /**
     * 应用便啊吗
     */
    private String clientId;

    /**
     * 应用密钥
     */
    private String clientSecret;

    /**
     * 资源id列表
     */
    private String resourceIds;

    /**
     * 域
     */
    private String scope;

    /**
     * 授权方式
     */
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    private String webServerRedirectUri;

    /**
     * 权限列表
     */
    private String authorities;

    /**
     * 认证令牌时效
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌时效
     */
    private Integer refreshTokenValidity;

    /**
     * 扩展信息
     */
    private String additionalInformation;

    /**
     * 是否自动放行
     */
    private String autoApprove;
}
