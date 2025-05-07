package com.example.cartservice.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.relational.core.mapping.Column;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

public class CartDTO {
  private Long id;
  private String userEmail;
  private LocalDateTime createdDate;
  private List<ProductDTO> products;

  public CartDTO() {
  }

  public CartDTO(Long id, String userEmail, LocalDateTime createdDate, List<ProductDTO> products) {
    this.id = id;
    this.userEmail = userEmail;
    this.createdDate = createdDate;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public List<ProductDTO> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDTO> products) {
    this.products = products;
  }
}
