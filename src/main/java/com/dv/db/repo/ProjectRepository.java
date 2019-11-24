package com.dv.db.repo;

import com.dv.db.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    Project save(Project user);

    Optional<Project> findById(String id);
}
