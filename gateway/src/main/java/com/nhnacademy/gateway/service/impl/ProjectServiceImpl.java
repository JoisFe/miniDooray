package com.nhnacademy.gateway.service.impl;

import com.nhnacademy.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdaptor projectAdaptor;

    @Override
    public List<Project> findProjectList(int page) {
        return projectAdaptor.findProjects(page);
    }
}
