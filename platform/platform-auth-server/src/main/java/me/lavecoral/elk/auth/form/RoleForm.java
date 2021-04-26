package me.lavecoral.elk.auth.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

/**
 * @author lave
 * @date 2021/4/27 00:41
 */
public class RoleForm implements Serializable {
    private static final long serialVersionUID = -7971093352878179565L;
    @NotBlank
    private String name;
    @NotEmpty
    private Set<Long> permissions;

    private Boolean enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Long> permissions) {
        this.permissions = permissions;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
