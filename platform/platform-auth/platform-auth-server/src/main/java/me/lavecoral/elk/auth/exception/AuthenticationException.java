package me.lavecoral.elk.auth.exception;

import me.lavecoral.elk.common.exception.BusinessException;

/**
 * @author lave
 * @date 2021/7/22 22:32
 */
public class AuthenticationException extends BusinessException {
    public static final AuthenticationException CLIENT_AUTHENTICATION_FAILED
            = new AuthenticationException("client.authentication.failed", "客户端认证失败");

    public AuthenticationException(String code, String message) {
        super(code, message);
    }
}
