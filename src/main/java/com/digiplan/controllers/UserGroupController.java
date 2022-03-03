package com.digiplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiplan.entities.UserGroup;
import com.digiplan.services.UserGroupService;

@RestController
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @GetMapping("/getUserGroup/{groupId}")
    public ResponseEntity<UserGroup> getUserGroup(@PathVariable String groupId) {
        UserGroup userGroup = this.userGroupService.getUserGroup(groupId);
        if (userGroup != null)
            return new ResponseEntity<UserGroup>(userGroup, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllUserGroups")
    public List<UserGroup> getAllUserGroups() {
        return this.userGroupService.getAllUserGroups();
    }

    @PostMapping("/addUserGroup")
    public ResponseEntity<UserGroup> addUserGroup(@RequestBody UserGroup userGroupData) {
        return new ResponseEntity<UserGroup>(this.userGroupService.addUserGroup(userGroupData), HttpStatus.CREATED);
    }

    @PutMapping("/updateUserGroup/{groupId}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable String groupId,
                                                     @RequestBody UserGroup userGroupData) {
        UserGroup userGroup = this.userGroupService.updateUserGroup(groupId, userGroupData);
        if (userGroup != null)
            return new ResponseEntity<UserGroup>(userGroup, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteUserGroup/{groupId}")
    public ResponseEntity<String> deleteUserGroup(@PathVariable String groupId) {
        String status = this.userGroupService.deleteUserGroup(groupId);
        if (status != null)
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
