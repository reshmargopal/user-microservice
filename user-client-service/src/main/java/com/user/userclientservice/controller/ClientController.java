package com.user.userclientservice.controller;

import com.user.userclientservice.feign.UserClient;
import com.user.userclientservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {
    @Autowired
    UserClient userClient;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return userClient.getUser(id);
    }

    @GetMapping("/users")
   public List<User> getAllUsers(){
        return userClient.getAllUsers();
    }

}
