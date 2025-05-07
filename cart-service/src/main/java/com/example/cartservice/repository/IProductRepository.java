package com.example.cartservice.repository;

import com.example.cartservice.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductRepository extends ReactiveCrudRepository<Product, Long> {
  Flux<Product> findAllByCartId(Long cartId);
}
