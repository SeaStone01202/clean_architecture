package com.food.ordering.system.userservice.controller;

import com.food.ordering.system.userservice.adapters.dto.UserRequest;
import com.food.ordering.system.userservice.adapters.dto.UserResponse;
import com.food.ordering.system.userservice.adapters.mapper.UserDataMapper;
import com.food.ordering.system.userservice.application.port.input.UserUseCase;
import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.valueobject.UserId;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase userUseCase;
    private final UserDataMapper userDataMapper;

    public UserController(UserUseCase userUseCase, UserDataMapper userDataMapper) {
        this.userUseCase = userUseCase;
        this.userDataMapper = userDataMapper;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        User user = userDataMapper.toUser(request);
        User created = userUseCase.createUser(user);
        return userDataMapper.toResponse(created);
    }

    @GetMapping("/{id}")
    public UserResponse find(@PathVariable Long id) {
        Optional<User> userOpt = userUseCase.getUser(new UserId(id));
        return userOpt.map(userDataMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
