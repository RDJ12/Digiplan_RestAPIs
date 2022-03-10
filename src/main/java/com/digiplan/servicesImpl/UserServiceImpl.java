package com.digiplan.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import org.json.simple.JSONObject;

import com.digiplan.entities.Cases;
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
        User user = null;
        try {
            if (userData.getPassword().equals(userData.getConfirmNewPassword())) {
                user = userRepository.findByUsernameAndPhoneNumber(userData.getUsername(), userData.getPhoneNumber());
                if (user != null) {
                    System.out.println(user.toString());
                    if (!user.getPassword().equals(userData.getPassword())) {
                        user.setPassword(userData.getPassword());
                        userRepository.saveAndFlush(user);
                        status = "Reset Successful";
                    }
                    status = "Reset Successful";
                }
            } else {
                status = "Password not matching";
            }
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

    @Override
    public List<User> getUsersList(String username) {
        log.info("@Start getUsersList");
        List<User> user = null;
        List<String> name = new ArrayList<>();
        List<String> caseName = new ArrayList<>();
        try {
            user = userRepository.findAllUsersList(username);
            for(User u:user){
                name.add(u.getUsername());
            }
            List<Cases> cases = null;

            CaseServiceImpl caseServiceImpl = null;
            cases = caseServiceImpl.getAllCases();

            for(Cases c:cases){
              //  caseName.add(new JSONObject());
                caseName.add(c.getFormData());
            }

        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return user;
    }

}
