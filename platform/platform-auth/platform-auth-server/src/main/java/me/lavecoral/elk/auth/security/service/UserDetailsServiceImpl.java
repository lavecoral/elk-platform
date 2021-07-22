package me.lavecoral.elk.auth.security.service;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.model.OAuthUserDetails;
import me.lavecoral.elk.auth.model.entity.Subject;
import me.lavecoral.elk.auth.model.enums.PasswordEncoderTypeEnum;
import me.lavecoral.elk.auth.repository.UsernamePasswordPrincipalRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author lave
 * @date 2021/7/22 22:19
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsernamePasswordPrincipalRepository usernamePasswordPrincipalRepository;

    private static final UsernameNotFoundException USERNAME_NOT_FOUND_EXCEPTION = new UsernameNotFoundException("subject not found");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw USERNAME_NOT_FOUND_EXCEPTION;
        }
        OAuthUserDetails oauthUserDetails = usernamePasswordPrincipalRepository.findByUsername(username)
                .map(principal -> {
                    Subject subject = principal.getSubject();
                    if (Objects.isNull(subject)) {
                        throw USERNAME_NOT_FOUND_EXCEPTION;
                    }

                    OAuthUserDetails details = new OAuthUserDetails();
                    details.setId(subject.getId());
                    details.setUsername(principal.getUsername());
                    details.setPassword(PasswordEncoderTypeEnum.BCRYPT.getPrefix() + principal.getPassword());
                    // TODO subject需要设置启用状态
                    details.setEnabled(subject.getEnable());
                    // TODO 设置用户权限信息
                    return details;
                }).orElseThrow(() -> USERNAME_NOT_FOUND_EXCEPTION);

        if (!oauthUserDetails.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!oauthUserDetails.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!oauthUserDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }

        return oauthUserDetails;
    }
}
