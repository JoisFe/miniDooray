package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adaptor.TagAdaptor;
import com.nhnacademy.gateway.domain.Tag;
import com.nhnacademy.gateway.service.TagService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagAdaptor tagAdaptor;

    @Override
    public String createTag(String tagTitle, Long projectNum, Long taskNum) {
        return tagAdaptor.createTag(tagTitle, projectNum, taskNum);
    }

    @Override
    public List<Tag> getTaskAll(Long projectNum, Long taskNum) {
        return tagAdaptor.findAllTag(projectNum, taskNum);
    }

    @Override
    public String update(String tagTitle, Long projectNum, Long taskNum, Long tagNum) {
        return tagAdaptor.update(tagTitle, projectNum, taskNum, tagNum);
    }

    @Override
    public String delete(Long projectNum, Long taskNum, Long tagNum) {
        return tagAdaptor.delete(projectNum, taskNum, tagNum);
    }
}
