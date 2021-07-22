package me.lavecoral.elk.auth.controller;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.api.SubjectApi;
import me.lavecoral.elk.auth.pojo.dto.SubjectDto;
import me.lavecoral.elk.auth.service.SubjectService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lave
 * @date 2021/7/21 23:27
 */
@RestController
@AllArgsConstructor
public class SubjectController implements SubjectApi {
    private final SubjectService subjectService;

    /**
     * 根据主体 ID获取主体信息
     *
     * @param id 主体ID
     * @return 主体信息
     */
    @Override
    public SubjectDto findOne(Long id) {
        return subjectService.findOne(id);
    }
}
