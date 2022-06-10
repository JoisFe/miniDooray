package com.nhnacademy.task.service.impl;

import com.nhnacademy.task.dto.respond.ProjectRespondDto;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.service.ProjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private static final int NUM_PER_PAGE = 5;

    private final ProjectRepository projectRepository;
    @Override
    public List<ProjectRespondDto> getProjects(int page) {
        Pageable pageable = PageRequest.of(page, NUM_PER_PAGE);

        return projectRepository.findAllBy(pageable).getContent();
    }
}
