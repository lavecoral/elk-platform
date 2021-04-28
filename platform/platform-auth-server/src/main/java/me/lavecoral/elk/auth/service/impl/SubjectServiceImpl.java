package me.lavecoral.elk.auth.service.impl;

import me.lavecoral.elk.common.exception.ObjectNotFoundException;
import me.lavecoral.elk.auth.model.Subject;
import me.lavecoral.elk.auth.repository.SubjectRepository;
import me.lavecoral.elk.auth.service.SubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lave
 * @date 2021/4/1 01:10
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(
            SubjectRepository subjectRepository
    ) {
        this.subjectRepository = subjectRepository;
    }

    /**
     * 根据名称查找主体
     *
     * @param name 主体名
     * @return 主体
     */
    @Override
    public Subject findByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new ObjectNotFoundException();
        }
        return subjectRepository.findByName(name).orElseThrow(ObjectNotFoundException::new);
    }

    /**
     * 查找全部主体
     *
     * @return 全部主体
     */
    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
}
