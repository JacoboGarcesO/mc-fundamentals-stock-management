package com.example.cartservice.repository;

import com.example.cartservice.model.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICartRepository extends ReactiveCrudRepository<Cart, Long> {
  Mono<Cart> findByUserEmail(String userEmail);
}
