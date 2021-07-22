package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.UsernamePasswordPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lave
 * @date 2021/7/22 22:05
 */
@Repository
public interface UsernamePasswordPrincipalRepository extends JpaRepository<UsernamePasswordPrincipal, Long> {
}
