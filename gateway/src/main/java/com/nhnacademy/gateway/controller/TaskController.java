package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.domain.Comment;
import com.nhnacademy.gateway.domain.Tag;
import com.nhnacademy.gateway.domain.Task;
import com.nhnacademy.gateway.dto.request.TaskRequestDto;
import com.nhnacademy.gateway.service.CommentService;
import com.nhnacademy.gateway.service.TagService;
import com.nhnacademy.gateway.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class TaskController {
    private final TaskService taskService;
    private final TagService tagService;
    private final CommentService commentService;

    @PostMapping("/project/{projectNum}/task/create/{memberNum}")
    public String taskCreate(TaskRequestDto taskRequestDto,
                             @PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "memberNum") Long memberNum,
                             Model model) {

        String message = taskService.createTask(taskRequestDto, projectNum, memberNum);

        model.addAttribute("message", message);

        return "redirect:/project/detail/" + projectNum;
    }

    @GetMapping("/project/{projectNum}/task/create/{memberNum}")
    public String taskCreatePage(TaskRequestDto taskRequestDto,
                                 @PathVariable(value = "projectNum") Long projectNum,
                                 @PathVariable(value = "memberNum") Long memberNum,
                                 Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("memberNum", memberNum);

        return "taskCreate";
    }

    @GetMapping("/project/{projectNum}/task/detail/{taskNum}")
    public String taskDetail(@PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "taskNum") Long taskNum,
                             Model model) {
        Task task = taskService.getTaskDetail(projectNum, taskNum);

        List<Comment> comments = commentService.getCommentList(projectNum, taskNum);

//        if (task.getTaskNum() == null) {
//            throw new NotFoundProjectException("해당 프로젝트가 존재하지 않습니다.");
//        }
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("task", task);
        model.addAttribute("commentList", comments);

        List<Tag> tags =
            tagService.getTaskAll(projectNum, taskNum); // taskDetail에 해당 태스크 놈들에 대한 태그 뿌리기
        model.addAttribute("tagList", tags);


        return "taskDetail";
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/update")
    public String updateTaskPage(@PathVariable(value = "projectNum") Long projectNum,
                                 @PathVariable(value = "taskNum") Long taskNum, Model model) {
        model.addAttribute("projectNum", projectNum);
        model.addAttribute("taskNum", taskNum);

        return "taskUpdate";
    }

    @PostMapping("/project/{projectNum}/task/{taskNum}/update")
    public String updateTask(TaskRequestDto taskRequestDto,
                             @PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "taskNum") Long taskNum) {
        String message = taskService.update(taskRequestDto, projectNum, taskNum);

        return "redirect:/project/detail/" + projectNum;
    }

    @GetMapping("/project/{projectNum}/task/{taskNum}/delete")
    public String deleteTask(@PathVariable(value = "projectNum") Long projectNum,
                             @PathVariable(value = "taskNum") Long taskNum) {
        String message = taskService.delete(projectNum, taskNum);

        return "redirect:/project/detail/" + projectNum;
    }
}