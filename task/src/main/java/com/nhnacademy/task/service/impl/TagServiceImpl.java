package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.respond.TagRespondDto;
import com.nhnacademy.task.entity.Tag;
import com.nhnacademy.task.entity.Task;
import com.nhnacademy.task.repository.TagRepository;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.TagService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;

    @Override
    public String createTag(Long projectNum, Long taskNum, String tagTitle) {
        Task task = taskRepository.findById(taskNum)
            .orElseThrow(() -> new RuntimeException("해당 task가 없습니다."));

        Tag tag = Tag.builder()
            .tagTitle(tagTitle)
            .task(task)
            .build();

        tagRepository.save(tag);

        return "tag가 저장되었습니다.";
    }

    @Override
    public List<TagRespondDto> findAllTag(Long projectNum, Long taskNum) {
        Task task = taskRepository.findById(taskNum)
            .orElseThrow(() -> new RuntimeException("해당 태스크는 존재하지 않습니다."));
        return tagRepository.findByTask(task);
    }

    @Override
    public String updateTag(Long projectNum, Long taskNum, Long tagNum, String tagTitle) {
        Optional<Tag> tag = tagRepository.findById(tagNum);

        if (tag.isEmpty()) {
            return "해당 tag가 존재하지 않습니다.";
        }

        Tag updateTag = tag.get();
        updateTag.setTagTitle(tagTitle);

        tagRepository.save(updateTag);

        return "해당 태그가 수정되었습니다.";
    }

    @Override
    public String deleteTag(Long projectNum, Long taskNum, Long tagNum) {
        tagRepository.deleteById(tagNum);
        return "해당 태그가 삭제되었습니다.";
    }
}
