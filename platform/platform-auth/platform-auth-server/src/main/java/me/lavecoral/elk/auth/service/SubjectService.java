package me.lavecoral.elk.auth.service;

import me.lavecoral.elk.auth.pojo.dto.SubjectDto;

/**
 * @author lave
 * @date 2021/7/21 23:28
 */
public interface SubjectService {

    /**
     * 根据主体 ID获取主体信息
     *
     * @param id 主体ID
     * @return 主体信息
     */
    SubjectDto findOne(Long id);
}
