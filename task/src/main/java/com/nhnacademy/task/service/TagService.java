package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.TagRespondDto;
import java.util.List;

public interface TagService {
    String createTag(Long projectNum, Long taskNum, String tagTitle);

    List<TagRespondDto> findAllTag(Long projectNum, Long taskNum);

    String updateTag(Long projectNum, Long taskNum, Long tagNum, String tagTitle);

    String deleteTag(Long projectNum, Long taskNum, Long tagNum);
}
