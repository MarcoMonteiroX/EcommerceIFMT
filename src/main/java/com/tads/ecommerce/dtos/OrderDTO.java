package com.tads.ecommerce.dtos;

import com.tads.ecommerce.entities.Order;
import com.tads.ecommerce.entities.enums.OrderStatus;

import java.time.Instant;

public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;
    private Long payment;
    private Long client;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Instant moment, OrderStatus status, Long payment, Long client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.payment = payment;
        this.client = client;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.payment = order.getPayment().getId();
        this.client = order.getClient().getId();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Long getPayment() {
        return payment;
    }

    public Long getClient() {
        return client;
    }
}
