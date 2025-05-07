package com.example.cartservice.dto;

public class GetProductDTO {
  private Long id;
  private String name;
  private String description;
  private Integer stock;

  public GetProductDTO(Long id, String name, String description, Integer stock) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.stock = stock;
  }

  public GetProductDTO() {
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

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
