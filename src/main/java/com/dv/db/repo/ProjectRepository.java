package com.dv.db.repo;

import com.dv.db.model.Project;
import com.dv.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    Project save(Project user);

    Optional<Project> findById(UUID id);

    List<Project> findAllByUser(User user);
}
