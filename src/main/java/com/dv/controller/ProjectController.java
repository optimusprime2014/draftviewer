package com.dv.controller;

import com.dv.controller.data.resp.Response;
import com.dv.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        return projectService.upload(file);
    }

    @GetMapping
    public Response info(@RequestParam String id) {
        return projectService.getInfo(id);
    }
}
