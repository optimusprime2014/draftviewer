package com.dv.db.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComboRepository {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public UserRepository getUserRepo() {
        return userRepository;
    }

    public ProjectRepository getProjectRepo() {
        return projectRepository;
    }
}
