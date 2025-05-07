package com.example.cartservice.controller;

import com.example.cartservice.dto.AddProductDTO;
import com.example.cartservice.dto.CartDTO;
import com.example.cartservice.model.Cart;
import com.example.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/carts")
public class CartController {
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @PostMapping("/{userEmail}")
  public Mono<Cart> createCart(@PathVariable String userEmail) {
    return cartService.createCart(userEmail);
  }

  @PostMapping("/{userEmail}/add-product")
  public Mono<CartDTO> addProduct(@RequestBody AddProductDTO addProductDTO, @PathVariable String userEmail) {
    return cartService.addProduct(addProductDTO, userEmail);
  }

  @PostMapping("/{userEmail}/make-purchase")
  public Mono<CartDTO> makePurchase(@PathVariable String userEmail) {
    return cartService.makePurchase(userEmail);
  }
}
