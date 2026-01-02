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
import java.util.Objects;

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

    public Order() {
    }

    public Order(Long id, OrderStatus orderStatus, BigDecimal total, LocalDateTime createdAt, Client client, List<OrderItem> orderItems, Payment payment) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.total = total;
        this.createdAt = createdAt;
        this.client = client;
        this.orderItems = orderItems;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && orderStatus == order.orderStatus && Objects.equals(total, order.total) && Objects.equals(createdAt, order.createdAt) && Objects.equals(client, order.client) && Objects.equals(orderItems, order.orderItems) && Objects.equals(payment, order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderStatus, total, createdAt, client, orderItems, payment);
    }
}
