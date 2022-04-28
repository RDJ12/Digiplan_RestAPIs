package com.digiplan.services;

import com.digiplan.entities.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public interface UserService {

    User getUser(Integer id);

    List<User> getAllUsers();

    User addUser(User userData);

    User updateUser(Integer id, User userData);

    String deleteUser(Integer id);

    JSONObject login(User userData);

    JSONObject forgetPassword(User userData);

    //For Receipt Application For @Tarun
    JSONArray getAllProviders();
}
