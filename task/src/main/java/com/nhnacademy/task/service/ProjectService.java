package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.ProjectRespondDto;
import java.util.List;

public interface ProjectService {
    List<ProjectRespondDto> getProjects(int page);
}
