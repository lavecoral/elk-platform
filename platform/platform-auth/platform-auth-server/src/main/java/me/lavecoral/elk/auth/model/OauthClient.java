package me.lavecoral.elk.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author lave
 * @date 2021/7/20 01:03
 */
@Entity
public class OauthClient implements Serializable {
    private static final long serialVersionUID = -3881148865505210433L;

    /**
     * 唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户端名称
     */
    private String name;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 客户端密钥
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("clientId='" + clientId + "'")
                .add("clientSecret='" + clientSecret + "'")
                .add("resourceIds='" + resourceIds + "'")
                .add("scope='" + scope + "'")
                .add("authorizedGrantTypes='" + authorizedGrantTypes + "'")
                .add("webServerRedirectUri='" + webServerRedirectUri + "'")
                .add("authorities='" + authorities + "'")
                .add("accessTokenValidity=" + accessTokenValidity)
                .add("refreshTokenValidity=" + refreshTokenValidity)
                .add("additionalInformation='" + additionalInformation + "'")
                .add("autoApprove='" + autoApprove + "'")
                .toString();
    }
}