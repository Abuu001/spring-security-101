package com.example.demo.Entity;

import lombok.Getter;

@Getter
public enum UserRoles {
    ADMIN("ADMIN"),
    USER("USER"),
    GUEST("GUEST");

    private final String role;

    UserRoles(String role) {
        this.role = role;
    }


}
