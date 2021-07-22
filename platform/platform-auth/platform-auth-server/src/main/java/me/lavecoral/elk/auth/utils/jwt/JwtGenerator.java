package me.lavecoral.elk.auth.utils.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;
import java.util.Set;

/**
 * @author lave
 * @date 2021/7/22 22:45
 */
@Component
@AllArgsConstructor
public class JwtGenerator {
    private final KeyPair keyPair;

    public String createAccessToken(Set<String> authorities, Map<String, String> additional) {
        String payload = new JwtPayloadBuilder()
                // 默认12小时
                .exp(12 * 3600)
                .authorities(authorities)
                .additional(additional)
                .builder();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RsaSigner signer = new RsaSigner(privateKey);
        return JwtHelper.encode(payload, signer).getEncoded();
    }
}
