package com.tads.ecommerce.dtos;

import com.tads.ecommerce.entities.Payment;

import java.time.Instant;

public class PaymentDTO {
    private Long id;
    private Long order;
    private Instant moment;

    public PaymentDTO() {
    }

    public PaymentDTO(Long id, Long order, Instant moment) {
        this.id = id;
        this.order = order;
        this.moment = moment;
    }

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.order = payment.getOrder().getId();
        this.moment = payment.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Long getOrder() {
        return order;
    }

    public Instant getMoment() {
        return moment;
    }
}
