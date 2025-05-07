package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
  private final IProductRepository productRepository;

  public ProductService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Flux<Product> getAll() {
    return productRepository.findAll();
  }

  public Mono<Product> getById(Long productId) {
    return productRepository
      .findById(productId)
      .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
  }
}
