package me.lavecoral.elk.auth.controller;

import me.lavecoral.elk.auth.model.Subject;
import me.lavecoral.elk.auth.service.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lave
 * @date 2021/4/1 01:10
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{name}")
    public Subject findByName(@PathVariable(name = "name") String name) {
        return this.subjectService.findByName(name);
    }
}
