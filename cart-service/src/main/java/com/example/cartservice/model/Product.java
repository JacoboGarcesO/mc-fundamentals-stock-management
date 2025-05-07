package com.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class Product {
  @Id
  @Column("product_id")
  private Long id;
  private String name;
  private String description;
  private Integer quantity;
  @Column("cart_id")
  private Long cartId;

  public Product() {
  }

  public Product(Long id, String name, String description, Integer quantity, Long cartId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.cartId = cartId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Long getCartId() {
    return cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }
}
