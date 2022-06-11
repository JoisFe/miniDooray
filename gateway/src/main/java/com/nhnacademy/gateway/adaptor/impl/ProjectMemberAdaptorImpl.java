package com.nhnacademy.gateway.adaptor.impl;

import com.nhnacademy.gateway.adaptor.ProjectMemberAdaptor;
import com.nhnacademy.gateway.config.DomainProperties;
import com.nhnacademy.gateway.domain.ProjectMember;
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
public class ProjectMemberAdaptorImpl implements ProjectMemberAdaptor {
    private final RestTemplate restTemplate;

    private final HttpHeaders headers = new HttpHeaders();

    private final DomainProperties domainProperties;

    @Override
    public List<ProjectMember> findProjects(Long memberNum, int page) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<ProjectMember>> httpEntity = new HttpEntity<>(headers);

        HttpEntity<List<ProjectMember>> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/member/{memberNum}?page={page}",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<ProjectMember>>() {},
            memberNum,
            page
        );

        return responds.getBody();
    }

    @Override
    public ProjectMember findProjectAdministrator(Long projectNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMember> httpEntity = new HttpEntity<>(headers);

        HttpEntity<ProjectMember> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/{projectNum}/member/administrator",
            HttpMethod.GET,
            httpEntity,
            ProjectMember.class,
            projectNum
        );

        return responds.getBody();
    }

    @Override
    public String registerProjectMember(Long memberNum, Long projectNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        HttpEntity<String> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/{projectNum}/member/register?memberNum={memberNum}",
            HttpMethod.GET,
            httpEntity,
            String.class,
            projectNum,
            memberNum
        );

        return responds.getBody();
    }
}
