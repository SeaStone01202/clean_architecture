package com.food.ordering.system.userservice.config;

import com.food.ordering.system.userservice.adapters.mapper.UserDataMapper;
import com.food.ordering.system.userservice.adapters.output.repository.UserRepositoryImpl;
import com.food.ordering.system.userservice.application.port.input.UserUseCase;
import com.food.ordering.system.userservice.application.service.UserApplicationService;
import com.food.ordering.system.userservice.domain.port.output.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserDataMapper userDataMapper() {
        return new UserDataMapper();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl(); // Sẽ thay bằng JPA sau
    }

    @Bean
    public UserUseCase userUseCase(UserRepository userRepository) {
        return new UserApplicationService(userRepository);
    }
}
