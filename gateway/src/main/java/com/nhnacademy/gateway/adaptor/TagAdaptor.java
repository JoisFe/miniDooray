package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Tag;
import java.util.List;

public interface TagAdaptor {
    String createTag(String tagTitle, Long projectNum, Long taskNum);

    List<Tag> findAllTag(Long projectNum, Long taskNum);

    String update(String tagTitle, Long projectNum, Long taskNum, Long tagNum);

    String delete(Long projectNum, Long taskNum, Long tagNum);
}
