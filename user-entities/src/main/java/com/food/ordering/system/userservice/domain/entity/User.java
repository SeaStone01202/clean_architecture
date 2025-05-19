package com.food.ordering.system.userservice.domain.entity;

import com.food.ordering.system.userservice.domain.valueobject.UserId;

public class User {
    private final UserId id;
    private final String name;
    private final String email;

    public User(UserId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
