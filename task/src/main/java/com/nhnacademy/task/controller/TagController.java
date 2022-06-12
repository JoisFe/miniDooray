package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.respond.TagRespondDto;
import com.nhnacademy.task.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TagController {
    private final TagService tagService;

    @GetMapping("/project/{projectNum}/task/{taskNum}/create")
    public String createTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum,
                            @RequestParam(value = "tagTitle") String tagTitle) {
        return tagService.createTag(projectNum, taskNum, tagTitle);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag")
    public List<TagRespondDto> findAllTag(@PathVariable(value = "projectNum") Long projectNum,
                                          @PathVariable(value = "taskNum") Long taskNum) {
        return tagService.findAllTag(projectNum, taskNum);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/register")
    public String updateTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum,
                            @PathVariable(value = "tagNum") Long tagNum,
                            @RequestParam(value = "tagTitle") String tagTitle) {
        return tagService.updateTag(projectNum, taskNum, tagNum, tagTitle);
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/tag/{tagNum}/delete")
    public String deleteTag(@PathVariable(value = "projectNum") Long projectNum,
                            @PathVariable(value = "taskNum") Long taskNum,
                            @PathVariable(value = "tagNum") Long tagNum) {
        return tagService.deleteTag(projectNum, taskNum, tagNum);
    }
}