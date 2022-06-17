package com.digiplan.controllers;

import com.digiplan.entities.User;
import com.digiplan.services.UserService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<Map> login(@RequestBody User userData) {
        return this.userService.login(userData);
    }

    @PostMapping("/forgetpassword")
    public ResponseEntity<Map> forgetPassword(@RequestBody User userData) {
        return this.userService.forgetPassword(userData);
    }

    //For Receipt Application For @Tarun
    @PostMapping(value = "/providers")
    public JSONArray getAllProviders() {
        return userService.getAllProviders();
    }

}
