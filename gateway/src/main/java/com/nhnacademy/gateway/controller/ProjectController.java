package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/projectList")
    public String getProjectList(
        @RequestParam(name = "page", required = false, defaultValue = "0") int page, Model model) {
        List<Project> projects = projectService.findProjectList(page);

        model.addAttribute("projectList", projects);
        return "projectList";
    }
}
