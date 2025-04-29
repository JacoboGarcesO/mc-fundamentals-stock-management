package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final IProductRepository productRepository;

  public ProductService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }
}
