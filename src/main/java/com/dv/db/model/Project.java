package com.dv.db.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "project")
public class Project {
    @Id
    private UUID id;
    private String name;
    private String tree;
}
