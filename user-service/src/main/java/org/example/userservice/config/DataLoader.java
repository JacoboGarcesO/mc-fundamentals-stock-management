package org.example.userservice.config;

import org.example.userservice.model.User;
import org.example.userservice.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner loadData(IUserRepository userRepository){
        return args -> {
            userRepository.save(new User(null, "123456789", "Cedula de ciudadania", "Juan", "Pérez", "sd@sd.com"));
            userRepository.save(new User(null, "1234456789", "Cedula de ciudadania", "Juan", "Pérez", "ssd@sds.com"));
        };
    }
}

