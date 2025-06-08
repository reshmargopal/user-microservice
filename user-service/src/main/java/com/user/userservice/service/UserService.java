package com.user.userservice.service;

import com.user.userservice.exception.UserNotFoundException;
import com.user.userservice.model.User;
import com.user.userservice.model.ValidUserProperties;
import com.user.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ValidUserProperties validUserProperties;

    public User register(User user){
        if (user.getAge() < validUserProperties.getAge() || !validUserProperties.getCountry().equalsIgnoreCase(user.getCountry()) ) {
            throw new IllegalArgumentException(
                    "Only adults from " + validUserProperties.getCountry() +
                            " and age above 18 are allowed to register.");
        }
        return userRepository.save(user);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


}
