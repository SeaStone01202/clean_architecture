package com.food.ordering.system.userservice.controller;

import com.food.ordering.system.userservice.adapters.dto.UserRequest;
import com.food.ordering.system.userservice.adapters.dto.UserResponse;
import com.food.ordering.system.userservice.adapters.mapper.UserDataMapper;
import com.food.ordering.system.userservice.application.port.input.UserUseCase;
import com.food.ordering.system.userservice.domain.entity.User;
import com.food.ordering.system.userservice.domain.valueobject.UserId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        User user = userDataMapper.toUser(request);
        User created = userUseCase.createUser(user);
        return ResponseEntity.status(201).body(userDataMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    public UserResponse find(@PathVariable Long id) {
        Optional<User> userOpt = userUseCase.getUser(new UserId(id));
        return userOpt.map(userDataMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
