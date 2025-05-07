package com.example.cartservice.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("carts")
public class Cart {
  @Id
  @Column("cart_id")
  private Long id;

  @Column("user_email")
  private String userEmail;

  @Column("created_date")
  private LocalDateTime createdDate;

  public Cart() {
  }

  public Cart(Long id, String userEmail) {
    this.id = id;
    this.userEmail = userEmail;
    this.createdDate = LocalDateTime.now();
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
}
