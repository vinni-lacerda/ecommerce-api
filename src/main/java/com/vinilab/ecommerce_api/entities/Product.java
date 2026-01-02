package com.vinilab.ecommerce_api.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private boolean isActive;

    @OneToOne
    private Stock stock;

    @OneToMany
    private List<OrderItem> orderItens = new ArrayList<OrderItem>();

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, boolean isActive, Stock stock, List<OrderItem> orderItens) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isActive = isActive;
        this.stock = stock;
        this.orderItens = orderItens;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<OrderItem> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItem> orderItens) {
        this.orderItens = orderItens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isActive == product.isActive && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(stock, product.stock) && Objects.equals(orderItens, product.orderItens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, isActive, stock, orderItens);
    }
}
