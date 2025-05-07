package com.example.notificationsservice.model;

import java.time.LocalDateTime;
import java.util.List;

public class CartEvent {
  private Long id;
  private String userEmail;
  private LocalDateTime createdDate;
  private List<Product> products;

  public CartEvent() {
  }

  public CartEvent(Long id, String userEmail, LocalDateTime createdDate, List<Product> products) {
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

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
