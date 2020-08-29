package com.dv.controller.data.resp;

import com.dv.db.model.Project;
import com.dv.db.model.ProjectFileType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ResponseProjectInfo {
    private UUID id;
    private String name;
    private String size;
    private List<ProjectFileType> fileTypes;
    private int files;
    private int folders;
    private LocalDateTime uploadDate;

    public ResponseProjectInfo(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.size = project.getSize();
        //TODO this.fileTypes = project.getFileTypes();
        this.files = project.getFiles();
        this.folders = project.getFolders();
        this.uploadDate = project.getUploadDate();
    }
}
