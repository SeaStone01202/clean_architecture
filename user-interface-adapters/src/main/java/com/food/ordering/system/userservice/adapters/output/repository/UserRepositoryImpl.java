package com.food.ordering.system.userservice.adapters.output.repository;

import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.port.output.repository.UserRepository;
import com.food.ordering.system.userservice.domain.valueobject.UserId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final Map<Long, User> memoryDB = new HashMap<>();
    private long autoId = 1L;

    @Override
    public Optional<User> findById(UserId id) {
        return Optional.ofNullable(memoryDB.get(id.getValue()));
    }

    @Override
    public User save(User user) {
        long id = autoId++;
        UserId userId = new UserId(id);
        User newUser = new User(userId, user.getName(), user.getEmail());
        memoryDB.put(id, newUser);
        return newUser;
    }
}
