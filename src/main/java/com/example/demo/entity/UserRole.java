package com.example.demo.entity;

import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;


public enum UserRole implements GrantedAuthority {
    ADMIN,
    MODERATOR,
    USER;

    @Override
    public String getAuthority() {
        return toString();
    }
}
