package me.lavecoral.elk.auth.service.impl;

import lombok.AllArgsConstructor;
import me.lavecoral.elk.auth.pojo.dto.SubjectDto;
import me.lavecoral.elk.auth.repository.SubjectRepository;
import me.lavecoral.elk.auth.repository.UsernamePasswordPrincipalRepository;
import me.lavecoral.elk.auth.service.SubjectService;
import me.lavecoral.elk.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lave
 * @date 2021/7/21 23:28
 */
@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final UsernamePasswordPrincipalRepository usernamePasswordPrincipalRepository;

    /**
     * 根据主体 ID获取主体信息
     *
     * @param id 主体ID
     * @return 主体信息
     */
    @Override
    public SubjectDto findOne(Long id) {
        return subjectRepository.findById(id)
                .map(subject -> {
                    SubjectDto subjectDto = new SubjectDto();
                    subjectDto.setId(subject.getId());
                    subjectDto.setName(subject.getName());
                    subjectDto.setAvatar(subject.getAvatar());

                    return subjectDto;
                }).orElseThrow(ObjectNotFoundException::new);
    }
}
