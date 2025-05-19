package com.food.ordering.system.userservice.adapters.mapper;

import com.food.ordering.system.userservice.adapters.dto.UserRequest;
import com.food.ordering.system.userservice.adapters.dto.UserResponse;
import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

public class UserDataMapper {

    public User toUser(UserRequest request) {
        return new User(null, request.getName(), request.getEmail());
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId().getValue(),
                user.getName(),
                user.getEmail()
        );
    }
}
