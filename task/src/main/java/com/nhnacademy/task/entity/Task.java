package com.nhnacademy.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskNum;

    @ManyToOne
    @JoinColumn(name = "project_num")
    private Project project;

    @OneToOne
    @JoinColumn(name = "milestone_num")
    private Milestone milestone;

    private String taskTitle;

    private String taskContent;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Tag> tags;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Comment> comments;
}
