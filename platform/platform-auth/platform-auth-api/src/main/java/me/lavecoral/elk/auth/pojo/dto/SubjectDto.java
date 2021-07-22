package me.lavecoral.elk.auth.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lave
 * @date 2021/7/21 23:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto implements Serializable {
    private static final long serialVersionUID = -5702699794657291696L;
    private Long id;
    private String name;
    private String avatar;
}
