package com.food.ordering.system.userservice.application.service;

import com.food.ordering.system.userservice.application.port.input.UserUseCase;
import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.port.output.repository.UserRepository;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

import java.util.Optional;

public class UserApplicationService implements UserUseCase {

    private final UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(UserId userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
