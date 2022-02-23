package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.User;

public interface UserService {

	public User getUser(Integer id);

	public List<User> getAllUsers();

	public User addUser(User userData);

	public User updateUser(Integer id, User userData);

	public String deleteUser(Integer id);
}
