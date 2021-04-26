package me.lavecoral.elk.auth.controller;

import me.lavecoral.elk.auth.dto.RoleDto;
import me.lavecoral.elk.auth.form.RoleForm;
import me.lavecoral.elk.auth.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lave
 * @date 2021/4/26 22:02
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id:^[1-9][0-9]*}")
    public RoleDto loadDetail(@PathVariable Long id) {
        return this.roleService.findOne(id);
    }

    @PostMapping("/")
    public Long create(@Validated @RequestBody RoleForm form) {
        return this.roleService.create(form);
    }

    @PutMapping("/{id:^[1-9][0-9]*}")
    public Long update(@PathVariable Long id, @Validated @RequestBody RoleForm form) {
        return this.roleService.update(id, form);
    }

    @PatchMapping("/{id:^[1-9][0-9]*}/enable")
    public Long enable(@PathVariable Long id) {
        return roleService.enable(id);
    }

    @PatchMapping("/{id:^[1-9][0-9]*}/disable")
    public Long disable(@PathVariable Long id) {
        return roleService.disable(id);
    }
}
