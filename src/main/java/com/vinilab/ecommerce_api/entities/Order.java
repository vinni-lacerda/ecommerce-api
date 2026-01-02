package com.vinilab.ecommerce_api.entities;

import com.vinilab.ecommerce_api.enums.OrderStatus;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OrderStatus orderStatus;

    private BigDecimal total;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @OneToMany
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @OneToOne
    private Payment payment;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
