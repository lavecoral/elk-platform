package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

/**
 * @author lave
 * @date 2021/4/26 21:44
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    /**
     * 根据给定的ID列表查找许可列表
     *
     * @param permissionIdList 许可ID列表
     * @return 许可列表
     */
    Set<Permission> findAllByIdIn(Collection<Long> permissionIdList);
}
