package com.nhnacademy.task.service;

import com.nhnacademy.task.dto.respond.ProjectMemberRespondDto;
import com.nhnacademy.task.entity.ProjectRole;
import java.util.List;

public interface ProjectMemberService {
    List<ProjectMemberRespondDto> getProjects(Long memberNum, int page);

    ProjectMemberRespondDto getProjectAdministratorByProjectNum(Long projectNum);

    String registerProjectMember(Long projectNum, Long memberNum);
}
