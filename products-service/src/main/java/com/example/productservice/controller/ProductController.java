package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public Flux<Product> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{productId}")
  public Mono<Product> getById(@PathVariable Long productId) {
    return productService.getById(productId);
  }
}
