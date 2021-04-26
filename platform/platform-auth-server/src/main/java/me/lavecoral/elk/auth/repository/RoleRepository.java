package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lave
 * @date 2021/4/26 21:26
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
