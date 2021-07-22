package me.lavecoral.elk.auth.model.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author lave
 * @date 2021/7/21 23:14
 */
@Data
@Entity
public class UsernamePasswordPrincipal implements Serializable {
    private static final long serialVersionUID = -2854159499387103747L;
    /**
     * 唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;
}
