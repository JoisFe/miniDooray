package com.nhnacademy.gateway.service;

import com.nhnacademy.gateway.domain.Milestone;
import java.util.List;

public interface MilestoneService {
    String createMilestone(String milestoneTitle, Long projectNum);

    String update(String milestoneTitle, Long projectNum, Long milestoneNum);

    String delete(Long projectNum, Long milestoneNum);

    List<Milestone> getMilestoneAll(Long projectNum);
}
