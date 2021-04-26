package me.lavecoral.elk.auth.dto;

import me.lavecoral.elk.auth.model.Permission;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author lave
 * @date 2021/4/26 22:04
 */
public class RoleDto implements Serializable {
    private static final long serialVersionUID = 7740705616510088125L;
    private Long id;
    private String name;
    private Boolean enable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PermissionDto> permissionList;

    public RoleDto() {
    }

    public RoleDto(Long id, String name, Boolean enable, LocalDateTime createdAt, LocalDateTime updatedAt, List<PermissionDto> permissionList) {
        this.id = id;
        this.name = name;
        this.enable = enable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.permissionList = permissionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PermissionDto> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionDto> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", permissionList=" + permissionList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(id, roleDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
