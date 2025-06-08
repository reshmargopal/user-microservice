package com.user.userservice.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "user.allowed")
public class ValidUserProperties {
    private String country;
    private int age;
}
