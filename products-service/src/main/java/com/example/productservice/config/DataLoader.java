package com.example.productservice.config;

import com.example.productservice.repository.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

  @Bean
  public CommandLineRunner loadData(IProductRepository productRepository) {
    return args -> {
      productRepository.save(new com.example.productservice.model.Product(null, "Product 1", "Description 1"));
      productRepository.save(new com.example.productservice.model.Product(null, "Product 2", "Description 2"));
    };
  }
}
