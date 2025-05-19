package com.food.ordering.system.userservice.domain.port.output.repository;

import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(UserId id);
    User save(User user);
}
