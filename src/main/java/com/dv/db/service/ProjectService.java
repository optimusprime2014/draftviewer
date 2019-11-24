package com.dv.db.service;

import com.dv.db.model.Project;
import com.dv.db.repo.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        log.info("Project: {} saved to db", project.toString());
        return projectRepository.save(project);
    }

    public Optional<Project> findProjectById(String id) {
        log.info("Project: id-{} finding into db", id);
        return projectRepository.findById(id);
    }
}
