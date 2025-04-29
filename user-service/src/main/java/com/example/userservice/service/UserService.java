package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository iUserRepository) {
        this.userRepository = iUserRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

}
