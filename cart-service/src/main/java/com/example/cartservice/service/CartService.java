package com.example.cartservice.service;

import com.example.cartservice.dto.AddProductDTO;
import com.example.cartservice.dto.CartDTO;
import com.example.cartservice.dto.GetProductDTO;
import com.example.cartservice.dto.ProductDTO;
import com.example.cartservice.event.CartEventPublisher;
import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Product;
import com.example.cartservice.repository.ICartRepository;
import com.example.cartservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CartService {
  private final ICartRepository cartRepository;
  private final IProductRepository productRepository;
  private final GetProductClient getProductClient;
  private final CartEventPublisher cartEventPublisher;

  public CartService(
    ICartRepository cartRepository,
    IProductRepository productRepository,
    GetProductClient getProductClient,
    CartEventPublisher cartEventPublisher) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepository;
    this.getProductClient = getProductClient;
    this.cartEventPublisher = cartEventPublisher;
  }

  public Mono<Cart> createCart(String userEmail) {
    return cartRepository.save(new Cart(null, userEmail));
  }

  public Mono<CartDTO> makePurchase(String userEmail) {
    return cartRepository.findByUserEmail(userEmail)
      .flatMap((cart) -> productRepository
        .findAllByCartId(cart.getId())
        .map(p -> new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getQuantity()))
        .collectList()
        .map(products -> {
          CartDTO cartDTO = new CartDTO(cart.getId(), userEmail, cart.getCreatedDate(), products);
          cartEventPublisher.publishPurchaseMadeEvent(cartDTO);
          return cartDTO;
        })
      );
  }

  public Mono<CartDTO> addProduct(AddProductDTO addProductDTO, String userEmail) {
    return getProductClient.getProduct(addProductDTO.getProductId())
      .flatMap(product -> {
        if (product.getStock() < addProductDTO.getQuantity()) {
          return Mono.error(new RuntimeException("Not enough stock"));
        }

        return cartRepository.findByUserEmail(userEmail)
          .flatMap(cart -> productRepository
            .save(new Product(null, product.getName(), product.getDescription(), addProductDTO.getQuantity(), cart.getId()))
            .flatMap((r) -> productRepository
              .findAllByCartId(cart.getId())
              .map(p -> new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getQuantity()))
              .collectList()
              .map(products -> new CartDTO(cart.getId(), userEmail, cart.getCreatedDate(), products))
            ));
      });
  }
}
