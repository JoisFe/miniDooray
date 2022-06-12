package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.request.TaskRequestDto;
import com.nhnacademy.task.dto.respond.TaskRespondDto;
import com.nhnacademy.task.entity.Project;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.TaskService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Override
    public String createTask(TaskRequestDto taskRequestDto,
                             Long projectNum) {
        Optional<Project> project = projectRepository.findById(projectNum);
        if (project.isEmpty()) {
            return "해당 프로젝트가 존재하지 않습니다.";
        }

        Task task = Task.builder()
            .project(project.get())
            .taskTitle(taskRequestDto.getTaskTitle())
            .taskContent(taskRequestDto.getTaskContent())
            .build();

        taskRepository.save(task);

        return "태스크가 저장되었습니다.";
    }

    @Override
    public Optional<TaskRespondDto> findTaskDetail(Long projectNum, Long taskNum) {
        Project project = projectRepository.findById(projectNum).orElseThrow(() -> new RuntimeException("해당 프로젝트가 존재하지 않습니다."));
//        if (project.isEmpty()) {
//            return TaskRespondDto.builder().build();
//        }
        TaskRespondDto taskRespondDto =
            taskRepository.findByProjectAndTaskNum(project, taskNum);

        return Optional.ofNullable(taskRespondDto);
    }

    @Override
    public List<TaskRespondDto> findTaskAll(Long projectNum) {
        Project project = projectRepository.findById(projectNum).orElseThrow(() -> new RuntimeException("해당 프로젝트가 존재하지 않습니다."));
        return taskRepository.findByProject(project);
    }

    @Override
    public String updateTask(TaskRequestDto taskRequestDto, Long projectNum, Long taskNum) {
        Optional<Task> task = taskRepository.findById(taskNum);
        if (task.isEmpty()) {
            return "해당 task가 존재하지 않습니다.";
        }

        Task updateTask = task.get();

        updateTask.setTaskTitle(taskRequestDto.getTaskTitle());
        updateTask.setTaskContent(taskRequestDto.getTaskContent());

        taskRepository.save(updateTask);

        return "task가 수정되었습니다.";
    }

    @Override
    public String deleteTask(Long projectNum, Long taskNum) {
        taskRepository.deleteById(taskNum);

        return "task가 삭제되었습니다.";
    }
}