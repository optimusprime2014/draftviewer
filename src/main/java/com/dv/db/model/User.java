package com.dv.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Set;
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Project> projects;

    public User() {
        super();
    }

    public User(String login, String pass, String email){
        this.id = UUID.randomUUID();
        this.login = login;
        this.pass = pass;
        this.email = email;
    }
}
