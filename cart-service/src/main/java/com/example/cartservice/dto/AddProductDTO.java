package com.example.cartservice.dto;

public class AddProductDTO {
  private Long productId;
  private Integer quantity;

  public AddProductDTO() {
  }

  public AddProductDTO(Long productId, Integer quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
