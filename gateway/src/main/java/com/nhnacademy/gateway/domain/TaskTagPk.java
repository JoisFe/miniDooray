package com.nhnacademy.gateway.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TaskTagPk {
    private Long tagNum;
    private Long taskNum;
}
