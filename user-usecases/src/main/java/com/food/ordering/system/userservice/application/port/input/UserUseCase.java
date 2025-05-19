package com.food.ordering.system.userservice.application.port.input;

import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

import java.util.Optional;

public interface UserUseCase {
    Optional<User> getUser(UserId userId);
    User createUser(User user);
}
