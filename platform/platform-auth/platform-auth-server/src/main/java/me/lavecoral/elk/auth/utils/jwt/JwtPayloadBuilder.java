package me.lavecoral.elk.auth.utils.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * 描述: [类型描述]
 * 创建时间: 2021/6/8
 *
 * @author hxr
 * @version 1.0.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class JwtPayloadBuilder {


    private final Map<String, Object> payload = new HashMap<>();


    /**
     * jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
     **/
    private final String jti = UUID.randomUUID().toString().replace("-", "");

    /**
     * jwt的签发时间
     **/
    private final LocalDateTime iat = LocalDateTime.now();

    /**
     * jwt的过期时间，这个过期时间必须要大于签发时间
     **/
    private LocalDateTime exp;

    /**
     * 权限集
     */
    private Set<String> authorities = new HashSet<>();

    /**
     * 附加的属性
     */
    private Map<String, String> additional;


    public JwtPayloadBuilder exp(int seconds) {
        this.exp = this.iat.plusSeconds(seconds);
        return this;
    }

    public JwtPayloadBuilder authorities(Set<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public JwtPayloadBuilder additional(Map<String, String> additional) {
        this.additional = additional;
        return this;
    }

    public String builder() {
        payload.put("jti", jti);
        payload.put("iat", this.iat.toEpochSecond(ZoneOffset.of("+8")));
        payload.put("exp", this.exp.toEpochSecond(ZoneOffset.of("+8")));
        if (Objects.nonNull(additional) && !additional.isEmpty()) {
            payload.putAll(additional);
        }
        payload.put("authorities", this.authorities.toArray());
        try {
            return new ObjectMapper().writeValueAsString(payload);
        } catch (Exception e) {
            // do nothing
        }
        return null;
    }


}
