package com.tads.ecommerce.dtos;

import com.tads.ecommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private Double price;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Integer quantity, Double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getOrder().getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
