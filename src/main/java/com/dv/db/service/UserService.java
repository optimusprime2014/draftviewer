package com.dv.db.service;

import com.dv.db.model.User;
import com.dv.db.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        log.info("User: {} saved to db", user.toString());
        return userRepository.save(user);
    }

    public Optional<User> findUserById(String id) {
        log.info("User: id-{} finding into db", id);
        return userRepository.findById(id);
    }

    public Optional<User> findUserByLoginAndPass(String login, String pass) {
        log.info("User: login-{}, finding into db", login);
        return userRepository.findByLoginAndPass(login, pass);
    }

    public Optional<User> finUserByLogin(String login) {
        log.info("User: login-{} finding into db", login);
        return userRepository.findFirstByLogin(login);
    }

    public Optional<User> findUserByEmail(String email) {
        log.info("User: email-{} finding into db", email);
        return userRepository.findFirstByEmail(email);
    }
}
