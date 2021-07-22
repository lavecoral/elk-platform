package me.lavecoral.elk.auth.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lave
 * @date 2021/7/21 22:58
 */
@Data
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 524593301358344132L;
    /**
     * 唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 主体是否可用
     */
    private Boolean enable;
}
