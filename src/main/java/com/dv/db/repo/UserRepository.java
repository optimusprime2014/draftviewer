package com.dv.db.repo;

import com.dv.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByLoginAndPass(String login, String pass);

    Optional<User> findFirstByLogin(String login);

    Optional<User> findFirstByEmail(String email);
}
