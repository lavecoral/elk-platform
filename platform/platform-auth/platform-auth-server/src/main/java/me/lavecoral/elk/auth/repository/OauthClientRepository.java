package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.entity.OauthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author lave
 * @date 2021/7/20 01:02
 */
@Repository
public interface OauthClientRepository extends JpaRepository<OauthClient, Long> {

    /**
     * 获取客户端信息
     *
     * @param clientId 客户端ID
     * @return 客户端信息
     */
    Optional<OauthClient> findByClientId(String clientId);
}
