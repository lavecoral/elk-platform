package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.entity.UsernamePasswordPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author lave
 * @date 2021/7/22 22:05
 */
@Repository
public interface UsernamePasswordPrincipalRepository extends JpaRepository<UsernamePasswordPrincipal, Long> {

    /**
     * 根据用户名查找凭证信息
     *
     * @param username 用户名
     * @return 凭证信息
     */
    Optional<UsernamePasswordPrincipal> findByUsername(String username);
}
