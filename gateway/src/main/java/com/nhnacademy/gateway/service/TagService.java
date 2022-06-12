package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.Tag;
import java.util.List;

public interface TagService {
    String createTag(String tagTitle, Long projectNum, Long taskNum);

    List<Tag> getTaskAll(Long projectNum, Long taskNum);

    String update(String tagTitle, Long projectNum, Long taskNum, Long tagNum);

    String delete(Long projectNum, Long taskNum, Long tagNum);
}
