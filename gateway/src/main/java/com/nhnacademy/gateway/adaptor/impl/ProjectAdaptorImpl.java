package com.nhnacademy.gateway.adaptor.impl;

import com.nhnacademy.gateway.adaptor.ProjectAdaptor;
import com.nhnacademy.gateway.config.DomainProperties;
import com.nhnacademy.gateway.domain.Member;
import com.nhnacademy.gateway.domain.Project;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<Project> findProjects(int page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<Project>> httpEntity = new HttpEntity<>(headers);

        HttpEntity<List<Project>> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/projectList?page={page}",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<Project>>() {},
            page
        );

        return responds.getBody();
    }
}
