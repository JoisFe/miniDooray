package com.nhnacademy.gateway.adaptor.impl;

import com.nhnacademy.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.gateway.config.DomainProperties;
import com.nhnacademy.gateway.domain.Project;
import com.nhnacademy.gateway.dto.request.ProjectRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ProjectAdaptorImpl implements ProjectAdaptor {
    private final RestTemplate restTemplate;

    private final HttpHeaders headers = new HttpHeaders();

    private final DomainProperties domainProperties;

//    @Override
//    public List<Project> findProjects(int page) {
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//
//        HttpEntity<List<Project>> httpEntity = new HttpEntity<>(headers);
//
//        HttpEntity<List<Project>> responds = restTemplate.exchange(
//            domainProperties.getTaskDomain() + "/project?page={page}",
//            HttpMethod.GET,
//            httpEntity,
//            new ParameterizedTypeReference<List<Project>>() {},
//            page
//        );
//
//        return responds.getBody();
//    }

    @Override
    public Project makeProject(
        ProjectRequestDto projectRequestDto, Long memberNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Project> httpEntity = new HttpEntity(projectRequestDto, headers);

        HttpEntity<Project> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/create/{memberNum}",
            HttpMethod.POST,
            httpEntity,
            Project.class,
            memberNum
        );

        return responds.getBody();
    }

    @Override
    public Project findProjectByProjectNum(Long projectNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Project> httpEntity = new HttpEntity<>(headers);

        HttpEntity<Project> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/{projectNum}",
            HttpMethod.GET,
            httpEntity,
            Project.class,
            projectNum
        );

        return responds.getBody();
    }
}
