package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.Project;
import java.util.List;

public interface ProjectService {
    List<Project> findProjectList(int page);
}
