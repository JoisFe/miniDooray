package com.nhnacademy.gateway.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ProjectMemberPk {
    private Long projectMemberNum;
    private Long projectNum;
}
