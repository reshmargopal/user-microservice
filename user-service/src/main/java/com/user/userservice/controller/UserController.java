package com.user.userservice.controller;

import com.user.userservice.model.User;
import com.user.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
       return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user,
                                      @RequestParam(defaultValue = "Not Provided") String city){
        user.setCity(user.getCity() == null ? city : user.getCity());

        try {
            User saved = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
