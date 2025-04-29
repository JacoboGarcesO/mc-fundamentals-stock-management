package com.example.userservice.config;

import com.example.userservice.model.User;
import com.example.userservice.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(IUserRepository userRepository) {
        return args -> {
            userRepository.save(new User(null, "Pepito", "pepito@gmail.com"));
            userRepository.save(new User(null, "Juan", "juan@gmail.com"));
        };
    }

}
