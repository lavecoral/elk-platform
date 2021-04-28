package me.lavecoral.elk.auth.service.impl;

import me.lavecoral.elk.auth.dto.PermissionDto;
import me.lavecoral.elk.auth.dto.RoleDto;
import me.lavecoral.elk.auth.form.RoleForm;
import me.lavecoral.elk.auth.model.Role;
import me.lavecoral.elk.auth.repository.PermissionRepository;
import me.lavecoral.elk.auth.repository.RoleRepository;
import me.lavecoral.elk.auth.service.RoleService;
import me.lavecoral.elk.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lave
 * @date 2021/4/26 22:03
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    /**
     * 根据ID查找角色信息
     *
     * @param id 角色ID
     * @return 角色详情
     */
    @Override
    public RoleDto findOne(Long id) {
        Optional<Role> role = this.roleRepository.findById(id);
        return role.map(r -> new RoleDto(
                r.getId(),
                r.getName(),
                r.getEnable(),
                r.getCreatedAt(),
                r.getUpdatedAt(),
                Optional.ofNullable(r.getPermissions())
                        .orElseGet(HashSet::new)
                        .stream()
                        .map(p -> new PermissionDto(p.getId(), p.getName(), p.getUri()))
                        .collect(Collectors.toList())
        )).orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public Long create(RoleForm form) {
        Role role = new Role();
        role.setName(form.getName().trim());
        role.setEnable(Boolean.TRUE);
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        role.setPermissions(
                Optional.ofNullable(permissionRepository.findAllByIdIn(form.getPermissions()))
                        .orElseGet(HashSet::new)
        );
        role = this.roleRepository.save(role);
        return role.getId();
    }

    @Override
    public Long update(Long id, RoleForm form) {
        Role role = roleRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        role.setUpdatedAt(LocalDateTime.now());
        role.setName(form.getName().trim());
        role.setEnable(form.getEnable());
        role.setPermissions(
                Optional.ofNullable(permissionRepository.findAllByIdIn(form.getPermissions()))
                        .orElseGet(HashSet::new)
        );
        role = roleRepository.save(role);
        return role.getId();
    }

    @Override
    public Long enable(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        role.setEnable(Boolean.TRUE);
        role.setUpdatedAt(LocalDateTime.now());
        role = roleRepository.save(role);
        return role.getId();
    }

    @Override
    public Long disable(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        role.setEnable(Boolean.FALSE);
        role.setUpdatedAt(LocalDateTime.now());
        role = roleRepository.save(role);
        return role.getId();
    }
}
