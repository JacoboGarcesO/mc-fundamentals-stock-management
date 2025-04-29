package com.example.orderservice.config;

import com.example.orderservice.repository.IOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.orderservice.model.Order;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(IOrderRepository orderRepository) {
        return args -> {
            orderRepository.save(new Order(null, "Order 1", 1));
            orderRepository.save(new Order(null, "Order 2", 3));
        };
    }
}
