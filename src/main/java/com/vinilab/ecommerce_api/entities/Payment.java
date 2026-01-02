package com.vinilab.ecommerce_api.entities;

import com.vinilab.ecommerce_api.enums.PaymentStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Order order;

    private BigDecimal price;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
}
