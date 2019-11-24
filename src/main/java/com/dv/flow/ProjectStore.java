package com.dv.flow;

import com.dv.controller.model.Response;
import org.springframework.web.multipart.MultipartFile;

public interface ProjectStore {
    Response parseProject(MultipartFile file);
}
