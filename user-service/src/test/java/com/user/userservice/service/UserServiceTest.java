package com.user.userservice.service;

import com.user.userservice.model.User;
import com.user.userservice.model.ValidUserProperties;
import com.user.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ValidUserProperties validProperties;

    @InjectMocks
    private UserService userService;

    @Test
    void registerUser() {
        User user = new User(null, "Reshma", 25, "France", "Paris");

        when(validProperties.getAge()).thenReturn(18);
        when(validProperties.getCountry()).thenReturn("France");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.register(user);

        assertNotNull(result);
        verify(userRepository).save(user);
    }

    @Test
    void invalidCountryCheck() {
        User user = new User(null, "Anu", 25, "India", "Bangalore");

        when(validProperties.getAge()).thenReturn(18);
        when(validProperties.getCountry()).thenReturn("France");

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> userService.register(user));

        assertEquals("Only adults from France and age above 18 are allowed to register.", ex.getMessage());
        verify(userRepository, never()).save(any());
    }

    @Test
    void invalidAgeCheck() {
        User user = new User(null, "Anu", 17, "France", "Paris");

        when(validProperties.getAge()).thenReturn(18);
        when(validProperties.getCountry()).thenReturn("France");

        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> userService.register(user));

        assertEquals("Only adults from France and age above 18 are allowed to register.", ex.getMessage());
        verify(userRepository, never()).save(any());
    }
}

