package com.dv.db;

import com.dv.db.service.ProjectService;
import com.dv.db.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DBService {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    public UserService getUserService() {
        log.info("UserService loaded");
        return userService;
    }

    public ProjectService getProjectService() {
        log.info("ProjectService loaded");
        return projectService;
    }
}
