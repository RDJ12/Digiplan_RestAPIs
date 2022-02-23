package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.UserGroup;
import com.digiplan.repositories.UserGroupRepository;
import com.digiplan.services.UserGroupService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;

	@Override
	public UserGroup getUserGroup(String groupId) {
		log.info("@Start getUserGroup");
		UserGroup userGroup = null;
		try {
			userGroup = userGroupRepository.getById(groupId); 
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return userGroup;
	}

	@Override
	public List<UserGroup> getAllUserGroups() {
		log.info("@Start getAllUserGroups");
		List<UserGroup> userGroupsList = null;
		try {
			userGroupsList = userGroupRepository.findAll();
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return userGroupsList;
	}

	@Override
	public UserGroup addUserGroup(UserGroup userGroupData) {
		log.info("@Start addUserGroup");
		UserGroup userGroup = null;
		try {
			userGroup = userGroupRepository.saveAndFlush(userGroupData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return userGroup;
	}

	@Override
	public UserGroup updateUserGroup(String groupId, UserGroup userGroupData) {
		log.info("@Start updateUserGroup");
		UserGroup userGroup = null;
		try {
			Optional<UserGroup> check = userGroupRepository.findById(groupId);
			if (check.isPresent())
				userGroup = userGroupRepository.saveAndFlush(userGroupData);
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return userGroup;
	}

	@Override
	public String deleteUserGroup(String groupId) {
		log.info("@Start deleteDoctor");
		String status = "";
		try {
			userGroupRepository.deleteById(groupId);
			status = "Deleted";
		} catch (Exception exception) {
			log.error("Exception = " + exception);
		}
		return status;
	}

}
