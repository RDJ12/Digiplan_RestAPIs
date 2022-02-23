package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.UserGroup;

public interface UserGroupService {

	public UserGroup getUserGroup(String groupId);

	public List<UserGroup> getAllUserGroups();

	public UserGroup addUserGroup(UserGroup userGroupData);

	public UserGroup updateUserGroup(String groupId, UserGroup userGroupData);

	public String deleteUserGroup(String groupId);
}
