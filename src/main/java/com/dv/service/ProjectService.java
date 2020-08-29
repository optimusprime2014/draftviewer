package com.dv.service;

import com.dv.db.model.Project;
import com.dv.db.repo.ComboRepository;
import com.dv.service.util.ConvertUtils;
import com.dv.service.util.ParseUtils;
import com.dv.controller.data.resp.Response;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

import static com.dv.controller.data.resp.ResponseStatus.*;

@Service
public class ProjectService {

    @Autowired
    private ConvertUtils convertUtils;

    @Autowired
    private ParseUtils parseUtils;

    @Autowired
    private ComboRepository repo;

    public Response upload(MultipartFile file) {
        String errorMessage = "Unable to parse project";

        Response response = Response.builder().build()
                .setStatus(SERVER_ERROR)
                .setMessage(errorMessage);

        parseUtils.parseFile(file).ifPresent(project -> {
            Project savedProject = repo.getProjectRepo().save(project);
            response
                    .setStatus(OK)
                    .setMessage(String.join(" ", "Project [", savedProject.getName(), "] uploaded"))
                    .setData(convertUtils.getProjectTree(savedProject));
        });

        return response;
    }

    public Response getInfo(String id) {
        Response response = Response.builder().build()
                .setStatus(SERVER_ERROR)
                .setMessage(String.join(" ", "Project [", id, "] didnt found"));

        repo.getProjectRepo().findById(UUID.fromString(id)).ifPresent(project -> {
            response
                    .setStatus(OK)
                    .setMessage(String.join(" ", "Project [", project.getName(), "] prepared"))
                    .setData(convertUtils.getProjectTree(project));
        });
        return response;
    }
}
