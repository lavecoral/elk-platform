package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lave
 * @date 2021/4/1 01:12
 */
@Mapper
public interface SubjectRepository {
    /**
     * 根据名称查找主体
     *
     * @param name 主体名
     * @return 主体
     */
    Subject findByName(@Param("name") String name);

    /**
     * 保存新增的主体
     *
     * @param subject 新增的主体
     * @return 新增主体的ID
     */
    Long insert(Subject subject);

    /**
     * 更新主体
     *
     * @param subject 更新主体
     * @return 主体的ID
     */
    Long update(Subject subject);

    /**
     * 查找全部的主体
     *
     * @return 全部的主体
     */
    List<Subject> findAll();

}
