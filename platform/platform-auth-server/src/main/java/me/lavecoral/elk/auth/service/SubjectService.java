package me.lavecoral.elk.auth.service;

import me.lavecoral.elk.auth.model.Subject;

import java.util.List;

/**
 * @author lave
 * @date 2021/4/1 01:10
 */
public interface SubjectService {
    /**
     * 根据名称查找主体
     *
     * @param name 主体名
     * @return 主体
     */
    Subject findByName(String name);

    /**
     * 查找全部主体
     *
     * @return 全部主体
     */
    List<Subject> findAll();
}
