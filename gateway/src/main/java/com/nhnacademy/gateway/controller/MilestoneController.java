package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MilestoneController {
    private final MilestoneService milestoneService;

    @GetMapping("/project/{projectNum}/milestone/register")
    public String createTagPage(@PathVariable(value = "projectNum") Long projectNum,
                                Model model) {
        model.addAttribute("projectNum", projectNum);
        return "milestoneCreate";
    }

    @PostMapping("/project/{projectNum}/milestone/register")
    public String createTag(String milestoneTitle,
                            @PathVariable(value = "projectNum") Long projectNum) {
        String message = milestoneService.createMilestone(milestoneTitle, projectNum);

        return "redirect:/project/detail/" + projectNum;
    }

    @GetMapping("/project/{projectNum}/milestone/{milestoneNum}/update")
    public String updateTagPage(@PathVariable(value = "projectNum") Long projectNum,
                                @PathVariable(value = "milestoneNum") Long milestoneNum, Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("milestoneNum", milestoneNum);

        return "milestoneUpdate";
    }

    @PostMapping("/project/{projectNum}/milestone/{milestoneNum}/update")
    public String updateTag(String milestoneTitle,
                            @PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "milestoneNum") Long milestoneNum) {
        String message = milestoneService.update(milestoneTitle, projectNum, milestoneNum);

        return "redirect:/project/detail/" + projectNum;
    }

    @GetMapping("/project/{projectNum}/milestone/{milestoneNum}/delete")
    public String deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "milestoneNum") Long milestoneNum) {
        String message = milestoneService.delete(projectNum, milestoneNum);

        return "redirect:/project/detail/" + projectNum;
    }
}
