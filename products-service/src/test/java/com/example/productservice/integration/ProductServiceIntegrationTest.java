package com.example.productservice.integration;

import com.example.productservice.model.Product;
import com.example.productservice.repository.IProductRepository;
import com.example.productservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceIntegrationTest {
  @Autowired
  private ProductService productService;
  @Autowired
  private IProductRepository productRepository;
  @Autowired
  private DatabaseClient databaseClient;

  @BeforeEach
  void setUp() {
    this.databaseClient.sql("DELETE FROM products").then().subscribe().dispose();
  }


  @Test
  void getAllProducts() {
    Product product = new Product(null, "Product 1", "Description 1", 10);
    Product product2 = new Product(null, "Product 2", "Description 1", 10);

    productRepository.save(product).block();
    productRepository.save(product2).block();

    Flux<Product> products = productService.getAll();

    StepVerifier
      .create(products)
      .assertNext(pr -> {
        assertEquals(product.getName(), pr.getName());
        assertEquals(11l, pr.getId());
      })
      .assertNext(pr -> {
        assertEquals(product2.getName(), pr.getName());
        assertEquals(12l, pr.getId());
      })
      .verifyComplete();
  }

  @Test
  void getById_WithExistingId_ShouldReturnProduct() {
    Product product = new Product(null, "Product 1", "Description 1", 10);

    productRepository.save(product).block();

    Mono<Product> products = productService.getById(11l);

    StepVerifier
      .create(products)
      .assertNext(pr -> {
        assertEquals(product.getName(), pr.getName());
        assertEquals(11l, pr.getId());
      })
      .verifyComplete();
  }

  @Test
  void getById_WithNotExistingId_ShouldReturnException() {
    Mono<Product> products = productService.getById(15l);

    StepVerifier
      .create(products)
      .expectError(RuntimeException.class);
  }
}
