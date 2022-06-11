package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.dto.request.ProjectRequestDto;
import com.nhnacademy.gateway.service.ProjectService;
import com.nhnacademy.gateway.vo.SecurityUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;

//    @GetMapping("/projectList")
//    public String getProjectList(
//        @RequestParam(name = "page", required = false, defaultValue = "0") int page, Model model) {
//        List<Project> projects = projectService.findProjectList(page);
//
//        model.addAttribute("projectList", projects);
//        return "projectList";
//    }

    @ModelAttribute("member")
    public SecurityUser getSessionMember(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        return (SecurityUser) session.getAttribute("member");
    }

    @GetMapping("/project/create")
    public String createProjectPage() {
        return "projectCreate";
    }

    @PostMapping("/project/create")
    public String project(ProjectRequestDto projectRequestDto,
                          @ModelAttribute("member") SecurityUser member) {
        projectService.createProject(projectRequestDto, member.getMemberNum());

        return "redirect:/projectList";
    }

    @GetMapping("/project/detail/{projectNum}")
    public String projectDetail(@PathVariable(value = "projectNum") Long projectNum,
                                @ModelAttribute("member") SecurityUser member, Model model) {
        Project project = projectService.findProject(projectNum);

        model.addAttribute("memberNum", member.getMemberNum());
        model.addAttribute("project", project);

        return "projectDetail";
    }

    @GetMapping("/project/{projectNum}/task/create/{memberNum}")
    public String taskCreatePage(@PathVariable(value = "projectNum") Long projectNum,
                                 @PathVariable(value = "memberNum") Long memberNum, Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("memberNum", memberNum);

        return "taskDetail";
    }
    //TODO : 여기서부터임!! projectNum은 필요한데 memberNum은 필요한가?
    @PostMapping("/project/{projectNum}/task/create/{memberNum}")
    public String taskCreate(@)
}
