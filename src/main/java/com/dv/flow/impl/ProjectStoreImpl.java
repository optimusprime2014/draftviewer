package com.dv.flow.impl;

import com.dv.db.DBService;
import com.dv.db.model.Project;
import com.dv.flow.util.ParseService;
import com.dv.flow.ProjectStore;
import com.dv.controller.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

import static com.dv.controller.model.ResponseStatus.*;

@Slf4j
@Service
public class ProjectStoreImpl implements ProjectStore {

    @Autowired
    ParseService parseService;

    private DBService dbService = new DBService();
    //private ProjectService projectService = dbService.getProjectService();

    @Override
    public Response parseProject(MultipartFile file) {
        String errorMessage = "Unable to parse project";
        log.info(errorMessage);

        Response response = Response.builder().build()
                .setStatus(SERVER_ERROR)
                .setMessage(errorMessage);

        Project newProject = new Project()
                .setId(UUID.randomUUID())
                .setName(file.getOriginalFilename())
                .setTree(parseService.parseFile(file).orElse(errorMessage));

        //TODO saving to DB: Optional.of(projectService.saveProject(newProject));
        Optional<Project> optProject = Optional.of(newProject);
        optProject.ifPresent(project ->
                response
                        .setStatus(OK)
                        .setMessage(Strings.EMPTY)
                        .setData(project)
        );

        return response;
    }
}
