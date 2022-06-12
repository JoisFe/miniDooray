package com.nhnacademy.gateway.adaptor.impl;

import com.nhnacademy.gateway.adaptor.TagAdaptor;
import com.nhnacademy.gateway.config.DomainProperties;
import com.nhnacademy.gateway.domain.Tag;
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
public class TagAdaptorImpl implements TagAdaptor {
    private final RestTemplate restTemplate;

    private final HttpHeaders headers = new HttpHeaders();

    private final DomainProperties domainProperties;

    @Override
    public String createTag(String tagTitle, Long projectNum, Long taskNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        HttpEntity<String> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() +
                "/project/{projectNum}/task/{taskNum}/create?tagTitle={tagTitle}",
            HttpMethod.GET,
            httpEntity,
            String.class,
            projectNum,
            taskNum,
            tagTitle
        );

        return responds.getBody();
    }

    @Override
    public List<Tag> findAllTag(Long projectNum, Long taskNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<Tag>> httpEntity = new HttpEntity<>(headers);

        HttpEntity<List<Tag>> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() + "/project/{projectNum}/task/{taskNum}/tag",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<Tag>>() {
            },
            projectNum,
            taskNum
        );

        return responds.getBody();
    }

    @Override
    public String update(String tagTitle, Long projectNum, Long taskNum, Long tagNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        HttpEntity<String> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() +
                "/project/{projectNum}/task/{taskNum}/tag/{tagNum}/register?tagTitle={tagTitle}",
            HttpMethod.GET,
            httpEntity,
            String.class,
            projectNum,
            taskNum,
            tagNum,
            tagTitle
        );

        return responds.getBody();
    }

    @Override
    public String delete(Long projectNum, Long taskNum, Long tagNum) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        HttpEntity<String> responds = restTemplate.exchange(
            domainProperties.getTaskDomain() +
                "/project/{projectNum}/task/{taskNum}/tag/{tagNum}/delete",
            HttpMethod.GET,
            httpEntity,
            String.class,
            projectNum,
            taskNum,
            tagNum
        );

        return responds.getBody();
    }
}
