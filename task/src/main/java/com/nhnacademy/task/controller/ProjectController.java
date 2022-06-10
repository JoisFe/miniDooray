package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.ProjectRespondDto;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/project/projectList")
    public List<ProjectRespondDto> getProjectList(@RequestParam(name = "page") int page) {
        return projectService.getProjects(page);
    }
}
