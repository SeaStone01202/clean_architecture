package com.food.ordering.system.userservice.adapters.output.repository;

import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.port.output.repository.UserRepository;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

import java.util.*;

public class FakeUserRepository implements UserRepository {

    private final Map<Long, User> database = new HashMap<>();
    private long idCounter = 1L;

    @Override
    public User save(User user) {
        if (user.getId() == null || user.getId().getValue() == null) {
            user.setId(new UserId(idCounter++));
        }
        database.put(user.getId().getValue(), user);
        return user;
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return Optional.ofNullable(database.get(userId.getValue()));
    }
}
