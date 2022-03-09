package com.digiplan.controllers;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.digiplan.entities.User;
import com.digiplan.services.UserService;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = this.userService.getUser(id);
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User userData) {
        return new ResponseEntity<User>(this.userService.addUser(userData), HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userData) {
        User user = this.userService.updateUser(id, userData);
        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        String status = this.userService.deleteUser(id);
        if (status.equals("Deleted"))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userData) {
        String isPresent = this.userService.login(userData);
        if (isPresent.equals("Logged In"))
            return new ResponseEntity<String>(isPresent, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/forgetpassword")
    public ResponseEntity<String> forgetPassword(@RequestBody User userData) {
        String status = this.userService.forgetPassword(userData);
        if (!status.equals(""))
            return new ResponseEntity<String>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/mycase")
    public List<User> myCases(@RequestBody User userData) {
        log.info("@Start myCases");

        List<User> list = new ArrayList<>();
        try {
            List<User> usersList = this.userService.getAllUsers();
            for (User user : usersList) {
                if (user.getUsername().equalsIgnoreCase(userData.getUsername()) && user.getTypeofUser().equals("DoctorAdmin")) {
                    list.add(user);
                }
            }
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return list;
    }

}
