package me.lavecoral.elk.auth.model;

import java.io.Serializable;

/**
 * @author lave
 * @date 2021/4/1 02:44
 */
public class RelSubjectRole implements Serializable {
    private static final long serialVersionUID = 475415494189597149L;
    private Long id;
    private Long subjectId;
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
