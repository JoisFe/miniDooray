package com.nhnacademy.task.dto.respond;

import com.nhnacademy.task.entity.Task;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TagRespondDto {
    private Long tagNum;

    private Task task;

    private String tagTitle;
}
