package com.user.userclientservice.feign;

import com.user.userclientservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserClient {

    @GetMapping("/user/{id}")
    ResponseEntity<User> getUser(@PathVariable String id);

    @GetMapping("/users")
    List<User> getAllUsers();
}
