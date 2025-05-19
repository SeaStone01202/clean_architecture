// dto/UserRequest.java
package com.food.ordering.system.userservice.adapters.dto;

public class UserRequest {
    private String name;
    private String email;

    // getters/setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
