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
@Table(name = "users")
public class User {
    @Id
    private UUID id;
    private String login;
    private String pass;
    private String email;
}
