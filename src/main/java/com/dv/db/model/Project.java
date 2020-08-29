package com.dv.db.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "projects")
public class Project {
    @Id
    private UUID id;
    private String name;
    private String size;
    /*@Type(
            type = "list-array",
            parameters = {
                    @Parameter(
                            name = ProjectFileType.class,
                            value = "file_type"
                    )
            }
    )*/
    /*@Column(
            name = "fileTypes",
            columnDefinition = "file_type[]"
    )
    private List<ProjectFileType> fileTypes;*/
    private int files;
    private int folders;
    @Column(name = "uploaddate")
    private LocalDateTime uploadDate;

    private String tree;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Project() {}
}
