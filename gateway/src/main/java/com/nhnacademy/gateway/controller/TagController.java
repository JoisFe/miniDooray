package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class TagController {
    private final TagService tagService;

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/register")
    public String createTagPage(@PathVariable(value = "projectNum") Long projectNum,
                                @PathVariable(value = "taskNum") Long taskNum,
                                Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("taskNum", taskNum);
        return "tagCreate";
    }

    @PostMapping("/project/{projectNum}/task/{taskNum}/tag/register")
    public String createTag(String tagTitle,
                            @PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum) {
        String message = tagService.createTag(tagTitle, projectNum, taskNum);

        return "redirect:/project/" + projectNum + "/task/detail/" + taskNum;
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/update")
    public String updateTagPage(@PathVariable(value = "projectNum") Long projectNum,
                                @PathVariable(value = "taskNum") Long taskNum,
                                @PathVariable(value = "tagNum") Long tagNum, Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("taskNum", taskNum);
        model.addAttribute("tagNum", tagNum);

        return "tagUpdate";
    }

    @PostMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/update")
    public String updateTag(String tagTitle,
                            @PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum,
                            @PathVariable(value = "tagNum") Long tagNum) {
        String message = tagService.update(tagTitle, projectNum, taskNum, tagNum);

        return "redirect:/project/" + projectNum + "/task/detail/" + taskNum;
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/delete")
    public String deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum,
                            @PathVariable(value = "tagNum") Long tagNum) {
        String message = tagService.delete(projectNum, taskNum, tagNum);

        return "redirect:/project/" + projectNum + "/task/detail/" + taskNum;
    }
}