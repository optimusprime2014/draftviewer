package com.dv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {

    /*@Autowired
    ProjectStoreImpl projectStore;

    @PostMapping("/upload")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        return projectStore.parseProject(file);
    }*/
}
