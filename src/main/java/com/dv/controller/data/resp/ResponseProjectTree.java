package com.dv.controller.data.resp;

import com.dv.db.model.Project;
import lombok.Getter;

public class ResponseProjectTree extends ResponseProjectInfo {
    @Getter
    private String tree;

    public ResponseProjectTree(Project project) {
        super(project);
        this.tree = project.getTree();
    }
}
