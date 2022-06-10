package com.nhnacademy.gateway.adaptor;

import com.nhnacademy.gateway.domain.Project;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProjectAdaptor {
    List<Project> findProjects(int page);
}
