package com.vinilab.ecommerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Order extends JpaRepository<Order, Long> {
}
