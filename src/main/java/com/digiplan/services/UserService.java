package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.User;

public interface UserService {

	 User getUser(Integer id);

	 List<User> getAllUsers();

	 User addUser(User userData);

	 User updateUser(Integer id, User userData);

	 String deleteUser(Integer id);
}
