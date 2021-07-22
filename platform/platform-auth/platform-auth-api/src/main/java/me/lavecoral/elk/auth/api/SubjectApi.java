package me.lavecoral.elk.auth.api;

import me.lavecoral.elk.auth.pojo.dto.SubjectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lave
 * @date 2021/7/21 23:24
 */
@RequestMapping("/api/v1/subject")
@FeignClient(value = "subject", contextId = "auth-application")
public interface SubjectApi {

    /**
     * 根据主体 ID获取主体信息
     *
     * @param id 主体ID
     * @return 主体信息
     */
    @GetMapping("/{id}")
    SubjectDto findOne(@PathVariable Long id);
}
