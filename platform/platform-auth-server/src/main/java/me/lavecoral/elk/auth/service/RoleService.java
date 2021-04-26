package me.lavecoral.elk.auth.service;

import me.lavecoral.elk.auth.dto.RoleDto;
import me.lavecoral.elk.auth.form.RoleForm;

/**
 * @author lave
 * @date 2021/4/26 22:03
 */
public interface RoleService {
    /**
     * 根据ID查找角色信息
     *
     * @param id 角色ID
     * @return 角色详情
     */
    RoleDto findOne(Long id);

    Long create(RoleForm form);

    Long update(Long id, RoleForm form);

    Long enable(Long id);

    Long disable(Long id);
}
