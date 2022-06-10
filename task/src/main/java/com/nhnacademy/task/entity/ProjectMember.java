package com.nhnacademy.task.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ProjectMember {
    @Id
    private Long projectMemberNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    private String projectMemberRole;
}
