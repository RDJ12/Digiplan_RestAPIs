package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.User;
import com.digiplan.repositories.UserRepository;
import com.digiplan.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Integer id) {
        log.info("@Start getUser");
        User user = null;
        try {
            Optional<User> check = userRepository.findById(id);
            if (check.isPresent())
                user = userRepository.getById(id);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        log.info("@Start getAllUsers");
        List<User> usersList = null;
        try {
            usersList = userRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return usersList;
    }

    @Override
    public User addUser(User userData) {
        log.info("@Start addUser");
        User user = null;
        try {
            user = userRepository.saveAndFlush(userData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return user;
    }

    @Override
    public User updateUser(Integer id, User userData) {
        log.info("@Start updateUser");
        User user = null;
        try {
            Optional<User> check = userRepository.findById(id);
            if (check.isPresent())
                user = userRepository.saveAndFlush(userData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return user;
    }

    @Override
    public String deleteUser(Integer id) {
        log.info("@Start deleteUser");
        String status = "Not Deleted";
        try {
            userRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

}
