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
        String status = "";
        try {
            userRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

    @Override
    public String login(User userData) {
        log.info("@Start login");
        User user = null;
        String isPresent = "";
        try {
            user = userRepository.findByUsernameAndPassword(userData.getUsername(), userData.getPassword());
            if (user != null)
                isPresent = "Logged In";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return isPresent;
    }

    @Override
    public String forgetPassword(User userData) {
        log.info("@Start forgetPassword");
        String status = "";
        List<User> usersList = null;
        try {
            if (userData.getPassword().equals(userData.getConfirmNewPassword())) {
                usersList = userRepository.findAll();
                for (User user : usersList) {
                    if (user.getUsername().equalsIgnoreCase(userData.getUsername()) && user.getPhoneNumber().longValue() == userData.getPhoneNumber().longValue()) {
                        if (!user.getPassword().equals(userData.getPassword())) {
                            user.setPassword(userData.getPassword());
                            userRepository.saveAndFlush(user);
                            status = "Reset Successful";
                        }
                        status = "Reset Successful";
                    }
                }
            } else {
                status = "Password not matching";
            }
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

}
