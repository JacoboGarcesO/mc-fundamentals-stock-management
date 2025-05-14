package com.example.cartservice.service;

import com.example.cartservice.dto.GetProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GetProductClient {
  private final WebClient.Builder webClientBuilder;
  private final String productsServiceUrl;

  public GetProductClient(WebClient.Builder webClientBuilder, @Value("${product.service.url}") String productsServiceUrl) {
    this.webClientBuilder = webClientBuilder;
    this.productsServiceUrl = productsServiceUrl;
  }

  public Mono<GetProductDTO> getProduct(Long productId) {
    return webClientBuilder
      .build()
      .get()
      .uri(productsServiceUrl + "/api/products/" + productId)
      .retrieve()
      .onStatus(status -> status.is4xxClientError(), response -> Mono.error(new RuntimeException("Product not found")))
      .bodyToMono(GetProductDTO.class);
  }
}
